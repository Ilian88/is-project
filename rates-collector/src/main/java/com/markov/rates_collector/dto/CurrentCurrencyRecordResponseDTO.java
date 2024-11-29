package com.markov.rates_collector.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CurrentCurrencyRecordResponseDTO {
    private String currency;
    private BigDecimal rate;
    private final LocalDateTime now = LocalDateTime.now();

    public String getCurrency() {
        return currency;
    }

    public CurrentCurrencyRecordResponseDTO setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public CurrentCurrencyRecordResponseDTO setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public LocalDateTime getNow() {
        return now;
    }
}
