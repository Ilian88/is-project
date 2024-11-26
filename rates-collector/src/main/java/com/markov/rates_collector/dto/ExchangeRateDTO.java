package com.markov.rates_collector.dto;

import java.math.BigDecimal;
import java.util.Map;

//TODO: validation on the DTO
public class ExchangeRateDTO {
    private Map<String, BigDecimal> rates;

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
