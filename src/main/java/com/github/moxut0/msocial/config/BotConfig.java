package com.github.moxut0.msocial.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class BotConfig {
    @Value("${botName}")
    private String name;
    @Value("botToken")
    private String token;
}
