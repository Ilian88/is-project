package com.markov.rates_collector.service;

import com.markov.rates_collector.dto.ExchangeRateResponseDTO;

public interface ExchangeRateService {
    void saveRates(ExchangeRateResponseDTO dto);
}
