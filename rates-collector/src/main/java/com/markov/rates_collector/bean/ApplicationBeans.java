package com.markov.rates_collector.bean;

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
