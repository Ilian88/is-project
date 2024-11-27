package com.markov.rates_collector.bean;

import com.markov.rates_collector.model.ExchangeRate;
import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Configuration
public class ApplicationBeans {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        Converter<String, LocalDate> stringToDateConverter = mappingContext ->{
//            LocalDate parse = LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ISO_LOCAL_DATE);
//
//            return parse;
//        } ;
//        Converter<Map<String, BigDecimal>, List<ExchangeRate>> exchangeRatesConverter = mappingContext -> {
//            Map<String, BigDecimal> dto = mappingContext.getSource();
//            List<ExchangeRate> list = dto.entrySet().stream().map(entry -> new ExchangeRate(entry.getKey(), entry.getValue())).toList();
//            return list;
//        };
//
////        modelMapper.addConverter(stringToDateConverter);
////        modelMapper.addConverter(exchangeRatesConverter);

        return modelMapper;
    }
}
