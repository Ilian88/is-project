package com.markov.json_api.contoller;

import com.markov.json_api.service.RequestRecordService;
import com.markov.json_api.model.dto.RequestRecordDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json_api")
public class RequestRecordController {
    private final RequestRecordService requestRecordService;

    public RequestRecordController(RequestRecordService requestRecordService) {
        this.requestRecordService = requestRecordService;
    }

    public ResponseEntity getRecordByCurrency(@RequestBody RequestRecordDTO dto) {

    }
}
