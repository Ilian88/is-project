package com.markov.rates_collector.schedule;

import com.markov.rates_collector.dto.ExchangeRateResponseDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExchangeRatesTask {
    private static final String EXCHANGE_RATE_SUPPLIER_URL = "http://data.fixer.io/api/latest";

    private final RestTemplate restTemplate;


    public ExchangeRatesTask(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void getExchangeRates(){
        restTemplate.getForObject(buildUri(), ExchangeRateResponseDTO.class);
    }

    private String buildUri() {
        return UriComponentsBuilder.fromUriString(EXCHANGE_RATE_SUPPLIER_URL)
                .queryParam("access_key", "").toUriString(); //TODO: add the access key
    }
}
