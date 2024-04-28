package com.github.moxut0.msocial.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @Column(name = "chat_id", columnDefinition = "BIGINT", nullable = false)
  private long chatId;

  @Column(name = "username", columnDefinition = "TEXT")
  private String username;

  @Column(name = "last_message_at", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime lastMessageAt;

}
