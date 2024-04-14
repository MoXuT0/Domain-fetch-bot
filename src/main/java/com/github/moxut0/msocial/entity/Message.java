package com.github.moxut0.msocial.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
  private long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String request;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String response;

  public Message(User user, String request, String response) {
    this.user = user;
    this.request = request;
    this.response = response;
  }
}
