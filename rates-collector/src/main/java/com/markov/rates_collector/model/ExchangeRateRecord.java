package com.markov.rates_collector.model;

import com.markov.rates_collector.enums.ExchangeRateRequestStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exchange_rates_record")
public class ExchangeRateRecord {
    private String id;
    private boolean success;
    private long timestamp;
    private String base;
    private LocalDate date;
    private List<ExchangeRate> rates;

    @Id
    @GeneratedValue(generator = "UUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<ExchangeRate> getRates() {
        return rates;
    }

    public ExchangeRateRecord setRates(List<ExchangeRate> rates) {
        this.rates = rates;
        return this;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public ExchangeRateRecord setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Column(name = "base_currency", nullable = false)
    public String getBase() {
        return base;
    }

    public ExchangeRateRecord setBase(String base) {
        this.base = base;
        return this;
    }

    @Column(name = "timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    public ExchangeRateRecord setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Column(name = "request_status")
    public boolean isSuccess() {
        return success;
    }

    public ExchangeRateRecord setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public String toString() {
        return "ExchangeRateRecord{" +
                "id='" + id + '\'' +
                ", success=" + success +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
