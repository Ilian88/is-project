package com.markov.rates_collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RatesCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatesCollectorApplication.class, args);

	}

}
