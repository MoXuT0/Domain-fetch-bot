package com.github.moxut0.msocial.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyDomainDto {

    private String domainName;
    private int hotness;
    private int price;
    private int xValue;
    private int yandexTic;
    private int links;
    private int visitors;
    private String registrar;
    private int old;
    private LocalDate deleteDate;
    private boolean rkn;
    private boolean judicial;
    private boolean block;

}
