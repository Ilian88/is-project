package com.markov.json_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationBeans {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
