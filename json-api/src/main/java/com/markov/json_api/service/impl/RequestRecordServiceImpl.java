package com.markov.json_api.service.impl;

import com.markov.json_api.error.RecordExistsException;
import com.markov.json_api.model.dto.CurrencyResponseDTO;
import com.markov.json_api.model.dto.GetCurrencyDTO;
import com.markov.json_api.model.dto.RequestRecordDTO;
import com.markov.json_api.props.AppProperties;
import com.markov.json_api.repo.RequestRecordRepo;
import com.markov.json_api.service.RequestRecordService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Service
public class RequestRecordServiceImpl implements RequestRecordService {
    private final AppProperties appProperties;
    private final RequestRecordRepo requestRecordRepo;

    public RequestRecordServiceImpl(AppProperties appProperties, RequestRecordRepo requestRecordRepo) {
        this.appProperties = appProperties;
        this.requestRecordRepo = requestRecordRepo;
    }

    public CurrencyResponseDTO getRecordByCurrency(RequestRecordDTO dto) throws RecordExistsException {
        if (checkIfRecordExists(dto.getRequestId())) {
            throw new RecordExistsException("Record with that id already exists");
        }

        String url = constructCurrencyUrl(dto.getCurrency());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, GetCurrencyDTO.class);



    }

    private boolean checkIfRecordExists(String requestId) {
        return requestRecordRepo.existsById(UUID.fromString(requestId));
    }

    private String constructCurrencyUrl(String currencyName) {
        String host = appProperties.getCurrencyServerHost();
        String port = appProperties.getCurrencyServerPort();

        return UriComponentsBuilder.newInstance()
                .host(host)
                .port(port)
                .path("currency")
                .path("current")
                .queryParam("currency", currencyName)
                .build()
                .toString();
    }
}
