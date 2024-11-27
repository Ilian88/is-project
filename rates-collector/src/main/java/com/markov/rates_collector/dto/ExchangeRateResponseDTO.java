package com.markov.rates_collector.dto;

import java.math.BigDecimal;
import java.util.Map;

//TODO: validation on the DTO
public class ExchangeRateResponseDTO {
    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Map<String, BigDecimal> rates;


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

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }



    @Override
    public String toString() {
        return "ExchangeRateResponseDTO{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", baseCurrency='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
