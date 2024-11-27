package com.markov.rates_collector.model.mapper;

import com.markov.rates_collector.dto.ExchangeRateResponseDTO;
import com.markov.rates_collector.model.ExchangeRate;
import com.markov.rates_collector.model.ExchangeRateRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExchangeRateRecordMapper {
    private static class InstanceHolder {
        private static final ExchangeRateRecordMapper INSTANCE = new ExchangeRateRecordMapper();
    }

    public static ExchangeRateRecordMapper getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public ExchangeRateRecord mapFromExchangeRateResponseDTO(ExchangeRateResponseDTO dto) {
        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        List<ExchangeRate> rates = dto.getRates()
                .entrySet()
                .stream()
                .map(entry -> new ExchangeRate(entry.getKey(), entry.getValue()))
                .toList();

        ExchangeRateRecord exchangeRateRecord = new ExchangeRateRecord();

        exchangeRateRecord
                .setSuccess(dto.isSuccess())
                .setBase(dto.getBase())
                .setDate(date)
                .setRates(rates)
                .setTimestamp(dto.getTimestamp());

        return exchangeRateRecord;
    }
}
