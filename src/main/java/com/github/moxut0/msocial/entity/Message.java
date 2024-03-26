package com.github.moxut0.msocial.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String request;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String response;

}
