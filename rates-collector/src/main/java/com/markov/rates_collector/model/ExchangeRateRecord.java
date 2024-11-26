package com.markov.rates_collector.model;

import com.markov.rates_collector.enums.ExchangeRateRequestStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exchange_rates_record")
public class ExchangeRateRecord {
    private String id;
    private ExchangeRateRequestStatus requestStatus;
    private long timestamp;
    private String base;
    private LocalDate date;
    private List<ExchangeRate> exchangeRates;

    @Id
    @GeneratedValue(generator = "UUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "base_currency", nullable = false)
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Column(name = "timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "request_status")
    public ExchangeRateRequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(ExchangeRateRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
