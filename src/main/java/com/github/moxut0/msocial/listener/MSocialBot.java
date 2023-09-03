package com.github.moxut0.msocial.listener;

import com.github.moxut0.msocial.client.TelegramBotClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.util.WebhookUtils;

@Component
public class MSocialBot implements LongPollingBot {

  private final TelegramBotClient telegramBotClient;
  private final String botToken;
  private final String botUsername;

  public MSocialBot(TelegramBotClient telegramBotClient,
                    @Value("${bot.token}") String botToken,
                    @Value("${bot.username}") String botUsername) {
    this.telegramBotClient = telegramBotClient;
    this.botToken = botToken;
    this.botUsername = botUsername;
  }

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      switch (update.getMessage().getText()) {
        case "/start":
            sendMessage(update.getMessage().getChatId(), "Hello!");
            break;
        default:
          sendMessage(update.getMessage().getChatId(), "I don't understand you");
              break;
      }
    }
  }

  @Override
  public BotOptions getOptions() {
    return telegramBotClient.getOptions();
  }

  @Override
  public void clearWebhook() throws TelegramApiRequestException {
    WebhookUtils.clearWebhook(telegramBotClient);
  }

  @Override
  public String getBotUsername() {
    return botUsername;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  public void sendMessage(long chatId, String textToSend) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(String.valueOf(chatId));
    sendMessage.setText(textToSend);
    sendMessage.setParseMode(ParseMode.HTML);
    try {
      telegramBotClient.execute(sendMessage);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}
