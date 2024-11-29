package com.markov.rates_collector.repo;

import com.markov.rates_collector.model.ExchangeRate;
import com.markov.rates_collector.model.ExchangeRateRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepo extends JpaRepository<ExchangeRateRecord, Long> {
    @Query(nativeQuery = true, value = "SELECT ex.rate, ex.currency " +
            "FROM exchange_rates ex JOIN exchange_rates_record_rates errr " +
            "ON ex.id = errr.rates_id join exchange_rates_record err " +
            "ON errr.exchange_rate_record_id = err.id " +
            "WHERE ex.currency = :currency " +
            "ORDER BY err.\"timestamp\" DESC " +
            "LIMIT 1;")
    Optional<ExchangeRate> findLastCurrencyRecord(@Param("currency") String currency);
}
