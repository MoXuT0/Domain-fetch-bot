package com.github.moxut0.msocial.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "chat_id")
  private long chatId;

  @Column(name = "last_message_at", nullable = false)
  private Instant lastMessageAt;

}
