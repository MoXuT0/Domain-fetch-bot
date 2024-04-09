package com.github.moxut0.msocial.service;

import com.github.moxut0.msocial.entity.User;
import com.github.moxut0.msocial.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public Optional<User> getByChatId(Long chatId) {
    return userRepository.findByChatId(chatId);
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public void update(User user) {
    user.setChatId(user.getChatId());
    user.setLastMessageAt(LocalDateTime.now());
    userRepository.save(user);
  }

}
