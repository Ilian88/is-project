package com.markov.json_api.service.impl;

import com.markov.json_api.error.RecordExistsException;
import com.markov.json_api.model.dto.CurrencyResponseDTO;
import com.markov.json_api.model.dto.RequestRecordDTO;
import com.markov.json_api.repo.RequestRecordRepo;
import com.markov.json_api.service.RequestRecordService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RequestRecordServiceImpl implements RequestRecordService {
    private final RequestRecordRepo requestRecordRepo;

    public RequestRecordServiceImpl(RequestRecordRepo requestRecordRepo) {
        this.requestRecordRepo = requestRecordRepo;
    }

    public CurrencyResponseDTO getRecordByCurrency(RequestRecordDTO dto) throws RecordExistsException {
        if (checkIfRecordExists(dto.getRequestId())) {
            throw new RecordExistsException("Record with that id already exists");
        };

        
    }

    private boolean checkIfRecordExists(String requestId) {
        return requestRecordRepo.existsById(UUID.fromString(requestId));
    }
}
