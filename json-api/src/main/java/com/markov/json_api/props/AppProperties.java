package com.markov.json_api.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    @Value("${currency.server.host}")
    private String currencyServerHost;

    @Value("${currency.server.port}")
    private String currencyServerPort;

    public String getCurrencyServerHost() {
        return currencyServerHost;
    }

    public void setCurrencyServerHost(String currencyServerHost) {
        this.currencyServerHost = currencyServerHost;
    }

    public String getCurrencyServerPort() {
        return currencyServerPort;
    }

    public void setCurrencyServerPort(String currencyServerPort) {
        this.currencyServerPort = currencyServerPort;
    }
}
