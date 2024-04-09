package com.github.moxut0.msocial.service;

import com.github.moxut0.msocial.entity.Message;
import com.github.moxut0.msocial.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

  private final MessageRepository messageRepository;

  public Message save(Message message) {
    return messageRepository.save(message);
  }
}
