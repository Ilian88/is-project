package com.markov.rates_collector.schedule;

import com.markov.rates_collector.dto.ExchangeRateResponseDTO;
import com.markov.rates_collector.error.RestTemplateErrorHandler;
import com.markov.rates_collector.service.ExchangeRateService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class ExchangeRatesTask {
    private static final Logger logger = LogManager.getLogger(ExchangeRatesTask.class);
    private static final String EXCHANGE_RATE_SUPPLIER_URL = "http://data.fixer.io/api/latest";
//    private static final String ACCESS_KEY = "c59d72fab8d648f373b203fae218e79c"; //TODO: move to properties file
    private static final String ACCESS_KEY = "b8e1eada99adf37f81bca3543f86d750"; //TODO: move to properties file

    private final ExchangeRateService exchangeRateService;
    private final RestTemplate restTemplate;


    public ExchangeRatesTask(ExchangeRateService exchangeRateService, RestTemplate restTemplate) {
        this.exchangeRateService = exchangeRateService;
        this.restTemplate = restTemplate;
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());
    }

//    @Scheduled(cron = "0 0/5 * * * ?")
//    @Scheduled(cron = "* * * * * *")
    @Scheduled(cron = "*/20 * * * * *")
    public void getExchangeRates(){
        logger.log(Level.INFO, "Sending exchange rates request to fixer.io");

        ExchangeRateResponseDTO exchangeRateDTO = restTemplate.getForObject(buildUri(), ExchangeRateResponseDTO.class);
        logger.log(Level.INFO,  String.format("Exchange rates response is: %s", exchangeRateDTO.toString()));

        exchangeRateService.saveRates(exchangeRateDTO);
    }

    private String buildUri() {
        return UriComponentsBuilder.fromUriString(EXCHANGE_RATE_SUPPLIER_URL)
                .queryParam("access_key", ACCESS_KEY).toUriString();
    }
}
