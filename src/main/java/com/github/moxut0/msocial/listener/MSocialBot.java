package com.github.moxut0.msocial.listener;

import com.github.moxut0.msocial.config.BotConfig;
import com.github.moxut0.msocial.entity.DailyDomain;
import com.github.moxut0.msocial.entity.Message;
import com.github.moxut0.msocial.entity.User;
import com.github.moxut0.msocial.service.DailyDomainService;
import com.github.moxut0.msocial.service.MessageService;
import com.github.moxut0.msocial.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class MSocialBot extends TelegramLongPollingBot {

  private final BotConfig botConfig;
  private final DailyDomainService dailyDomainService;
  private final MessageService messageService;
  private final UserService userService;

  public MSocialBot(BotConfig botConfig,
                    DailyDomainService dailyDomainService,
                    MessageService messageService,
                    UserService userService) {
    this.botConfig = botConfig;
    this.dailyDomainService = dailyDomainService;
    this.messageService = messageService;
    this.userService = userService;
  }


  @Override
  public void onUpdateReceived(Update update) {
    long chatId = update.getMessage().getChatId();
    if (update.hasMessage() && update.getMessage().hasText()) {
      Optional<User> userOptional = userService.getByChatId(chatId);
      if(userOptional.isEmpty()) {
        User newUser = new User(chatId, LocalDateTime.now());
        userService.save(newUser);
        userOptional = Optional.of(newUser);
      } else {
        userService.update(userOptional.get());
      }
      String response;
      switch (update.getMessage().getText()) {
        case "/start":
          response = "Hello!";
          break;
        default:
          response = "I don't understand you";
          break;
      }
      sendMessage(chatId, response);
      messageService.save(new Message(userOptional.get(), update.getMessage().getText(), response));
    }
  }

  @Override
  public String getBotUsername() {
    return botConfig.getName();
  }

  @Override
  public String getBotToken() {
    return botConfig.getToken();
  }


  public void sendMessage(long chatId, String textToSend) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(String.valueOf(chatId));
    sendMessage.setText(textToSend);
    sendMessage.setParseMode(ParseMode.HTML);
    try {
      this.execute(sendMessage);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

  @Scheduled(cron = "0 0 12 * * ?", zone = "Europe/Moscow")
  //@Scheduled(fixedRate = 30000, initialDelay = 10000)
  @Async
  @Transactional
  public void massSendDomains () {
    dailyDomainService.sendRequest();
    LocalDate date = LocalDate.now();
    List<DailyDomain> dailyDomains = dailyDomainService.getAll();
    List<User> users = userService.getAll();
    users.forEach(user -> sendMessage(
            user.getChatId(), date + ". Собрано " + dailyDomains.size() + " доменов"));
  }

}
