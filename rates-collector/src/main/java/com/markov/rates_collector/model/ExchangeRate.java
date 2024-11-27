package com.markov.rates_collector.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {
    private String currency;
    private BigDecimal rate;

    public ExchangeRate(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    @Id
    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "rate", nullable = false)
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
