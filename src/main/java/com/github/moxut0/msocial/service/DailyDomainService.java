package com.github.moxut0.msocial.service;

import com.github.moxut0.msocial.repository.DailyDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DailyDomainService {

  private final DailyDomainRepository dailyDomainRepository;

}
