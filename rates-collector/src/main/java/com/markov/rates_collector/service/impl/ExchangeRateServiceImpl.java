package com.markov.rates_collector.service.impl;

import com.markov.rates_collector.dto.ExchangeRateResponseDTO;
import com.markov.rates_collector.model.ExchangeRateRecord;
import com.markov.rates_collector.model.mapper.ExchangeRateRecordMapper;
import com.markov.rates_collector.service.ExchangeRateService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRecordMapper exchangeRateRecordMapper = ExchangeRateRecordMapper.getInstance();

    @Override
    public void saveRates(ExchangeRateResponseDTO dto) {

        ExchangeRateRecord ratesRecord = exchangeRateRecordMapper.mapFromExchangeRateResponseDTO(dto);
        System.out.println(ratesRecord.toString());
    }
}
