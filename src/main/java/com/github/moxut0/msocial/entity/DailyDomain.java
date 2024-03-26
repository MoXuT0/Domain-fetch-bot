package com.github.moxut0.msocial.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class DailyDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "domain_name", columnDefinition = "TEXT", nullable = false)
  private String domainName;

  @Column(name = "hotness", columnDefinition = "INT", nullable = false)
  private int hotness;

  @Column(name = "price", columnDefinition = "INT", nullable = false)
  private int price;

  @Column(name = "x_value", columnDefinition = "INT", nullable = false)
  private int xValue;

  @Column(name = "yandex_tic", columnDefinition = "INT", nullable = false)
  private int yandexTic;

  @Column(name = "links", columnDefinition = "INT", nullable = false)
  private int links;

  @Column(name = "visitors", columnDefinition = "INT", nullable = false)
  private int visitors;

  @Column(name = "registrar", columnDefinition = "TEXT", nullable = false)
  private String registrar;

  @Column(name = "old", columnDefinition = "INT", nullable = false)
  private int old;

  @Column(name = "delete_date", columnDefinition = "DATE", nullable = false)
  private LocalDate deleteDate;

  @Column(name = "rkn", columnDefinition = "BOOLEAN", nullable = false)
  private boolean rkn;

  @Column(name = "judicial", columnDefinition = "BOOLEAN", nullable = false)
  private boolean judicial;

  @Column(name = "block", columnDefinition = "BOOLEAN", nullable = false)
  private boolean block;

}
