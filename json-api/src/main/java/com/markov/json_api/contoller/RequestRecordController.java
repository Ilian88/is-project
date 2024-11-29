package com.markov.json_api.contoller;

import com.markov.json_api.props.AppProperties;
import com.markov.json_api.props.AppPropertiesConfig;
import com.markov.json_api.service.RequestRecordService;
import com.markov.json_api.model.dto.RequestRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("json_api")
public class RequestRecordController {

    @Autowired
    private final RequestRecordService requestRecordService;

    public RequestRecordController(RequestRecordService requestRecordService) {
        this.requestRecordService = requestRecordService;
    }

    @PostMapping("/current")
    public ResponseEntity getRecordByCurrency(@RequestBody RequestRecordDTO dto) {

    }


}
