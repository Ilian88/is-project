package com.markov.rates_collector.error;

import org.apache.coyote.BadRequestException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().value() != 200) {
            throw new BadRequestException(String.format("Problem connecting to exchange rate server: \n " + response.getStatusText()));
        }
    }
}

