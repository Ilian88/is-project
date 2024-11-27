package com.markov.rates_collector.repo;

import com.markov.rates_collector.model.ExchangeRateRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepo extends JpaRepository<ExchangeRateRecord, Long> {

}
