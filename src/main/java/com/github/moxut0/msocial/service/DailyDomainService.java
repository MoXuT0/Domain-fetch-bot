package com.github.moxut0.msocial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.moxut0.msocial.entity.DailyDomain;
import com.github.moxut0.msocial.repository.DailyDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.List;

@Service
public class DailyDomainService {

  private final DailyDomainRepository dailyDomainRepository;
  @Value("${backorder.url}")
  private final String URL;

  @Autowired
  public DailyDomainService(DailyDomainRepository dailyDomainRepository, @Value("${backorder.url}") String URL) {
    this.dailyDomainRepository = dailyDomainRepository;
    this.URL = URL;
  }

  public List<DailyDomain> getAll() {
    return dailyDomainRepository.findAll();
  }

  public void sendRequest() {
    RestTemplate restTemplate = new RestTemplate();
    String jsonString = restTemplate.getForObject(URL, String.class);
    ObjectMapper mapper = new ObjectMapper();
    try {
      dailyDomainRepository.deleteAll();
      List<DailyDomain> dailyDomains = mapper.readValue(jsonString, new TypeReference<>() {});
      dailyDomainRepository.saveAll(dailyDomains);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
