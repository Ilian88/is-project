package com.markov.json_api.repo;

import com.markov.json_api.model.RequestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRecordRepo extends JpaRepository<RequestRecord, UUID> {

}
