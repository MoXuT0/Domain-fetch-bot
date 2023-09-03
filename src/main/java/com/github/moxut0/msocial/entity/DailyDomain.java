package com.github.moxut0.msocial.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class DailyDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

}
