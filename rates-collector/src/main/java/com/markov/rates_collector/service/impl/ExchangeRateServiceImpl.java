package com.markov.rates_collector.service.impl;

import com.markov.rates_collector.dto.CurrentCurrencyRecordResponseDTO;
import com.markov.rates_collector.dto.ExchangeRateResponseDTO;
import com.markov.rates_collector.model.ExchangeRate;
import com.markov.rates_collector.model.ExchangeRateRecord;
import com.markov.rates_collector.model.mapper.ExchangeRateRecordMapper;
import com.markov.rates_collector.repo.ExchangeRateRepo;
import com.markov.rates_collector.service.ExchangeRateService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRecordMapper exchangeRateRecordMapper = ExchangeRateRecordMapper.getInstance();

    private final ExchangeRateRepo exchangeRateRepo;

    public ExchangeRateServiceImpl(ExchangeRateRepo exchangeRateRepo) {
        this.exchangeRateRepo = exchangeRateRepo;
    }

    @Override
    public void saveRates(ExchangeRateResponseDTO dto) {

        ExchangeRateRecord ratesRecord = exchangeRateRecordMapper.mapFromExchangeRateResponseDTO(dto);
        exchangeRateRepo.save(ratesRecord);
        exchangeRateRepo.flush();

        System.out.println(ratesRecord);
    }

    @Override
    public CurrentCurrencyRecordResponseDTO getLastCurrencyRecordFor(String currencyName) {
        ExchangeRate lastCurrencyRecord = this.exchangeRateRepo.findLastCurrencyRecord(currencyName).orElseGet(null);
        return mapEntityToDTO(lastCurrencyRecord);
    }

    private CurrentCurrencyRecordResponseDTO mapEntityToDTO(ExchangeRate lastCurrencyRecord) {
        CurrentCurrencyRecordResponseDTO currentCurrencyRecordResponseDTO = new CurrentCurrencyRecordResponseDTO();
        return currentCurrencyRecordResponseDTO
                .setRate(lastCurrencyRecord.getRate())
                .setCurrency(lastCurrencyRecord.getCurrency());
    }
}
