package com.markov.rates_collector.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {
    private UUID id;
    private String currency;
    private BigDecimal rate;

    public ExchangeRate(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
