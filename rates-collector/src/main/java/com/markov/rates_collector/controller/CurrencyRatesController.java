package com.markov.rates_collector.controller;

import com.markov.rates_collector.dto.CurrentCurrencyRecordResponseDTO;
import com.markov.rates_collector.service.ExchangeRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyRatesController {
    private final ExchangeRateService exchangeRateService;

    public CurrencyRatesController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/current")
    public ResponseEntity<CurrentCurrencyRecordResponseDTO> getCurrentRecordsForCurrency (@RequestParam(name = "currency") String currencyName) {
        CurrentCurrencyRecordResponseDTO lastCurrencyRecordFor = exchangeRateService.getLastCurrencyRecordFor(currencyName);

        return ResponseEntity.ok().body(lastCurrencyRecordFor);
    }
}
