package com.github.moxut0.msocial.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "chat_id")
  private long chatId;

  @UpdateTimestamp
  @Column(name = "last_message_at", nullable = false)
  private Instant lastMessageAt;

}
