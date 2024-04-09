package com.github.moxut0.msocial.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_domains")
@Data
public class DailyDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
  private long id;

  @JsonProperty(value = "domainname")
  @Column(name = "domain_name", columnDefinition = "TEXT", nullable = false)
  private String domainName;

  @JsonProperty(value = "hotness")
  @Column(name = "hotness", columnDefinition = "INT", nullable = false)
  private int hotness;

  @JsonProperty(value = "price")
  @Column(name = "price", columnDefinition = "INT", nullable = false)
  private int price;

  @JsonProperty(value = "x_value")
  @Column(name = "x_value", columnDefinition = "INT", nullable = false)
  private int xValue;

  @JsonProperty(value = "yandex_tic")
  @Column(name = "yandex_tic", columnDefinition = "INT", nullable = false)
  private int yandexTic;

  @JsonProperty(value = "links")
  @Column(name = "links", columnDefinition = "INT", nullable = false)
  private int links;

  @JsonProperty(value = "visitors")
  @Column(name = "visitors", columnDefinition = "INT", nullable = false)
  private int visitors;

  @JsonProperty(value = "registrar")
  @Column(name = "registrar", columnDefinition = "TEXT", nullable = false)
  private String registrar;

  @JsonProperty(value = "old")
  @Column(name = "old", columnDefinition = "INT", nullable = false)
  private int old;

  @JsonProperty(value = "delete_date")
  @Column(name = "delete_date", columnDefinition = "DATE", nullable = false)
  private Date deleteDate;

  @JsonProperty(value = "rkn")
  @Column(name = "rkn", columnDefinition = "BOOLEAN", nullable = false)
  private boolean rkn;

  @JsonProperty(value = "judicial")
  @Column(name = "judicial", columnDefinition = "BOOLEAN", nullable = false)
  private boolean judicial;

  @JsonProperty(value = "block")
  @Column(name = "block", columnDefinition = "BOOLEAN", nullable = false)
  private boolean block;

}
