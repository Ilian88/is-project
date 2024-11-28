package com.markov.json_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "request_records")
public class RequestRecord {
    private UUID requestId;
    private long timestamp;
    private int client;
    private String currency;


    @Id
    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    @Column
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Column
    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Column(nullable = false)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
