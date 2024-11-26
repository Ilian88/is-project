package com.markov.rates_collector.dto;

import java.time.LocalDate;
import java.util.List;

//TODO: validation on the DTO
public class ExchangeRateResponseDTO {
    private boolean success;
    private long timestamp;
    private String baseCurrency;
    private LocalDate date;
    private List<ExchangeRateDTO> rates;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ExchangeRateDTO> getRates() {
        return rates;
    }

    public void setRates(List<ExchangeRateDTO> rates) {
        this.rates = rates;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
}
