package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    Optional<Candidate> findCandidateById(CandidateId companyId);

    Optional<Candidate> findById_UserId_AndId_CompanyId_AndId_AccelerationId(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findById_CompanyId(Long companyId);

    List<Candidate> findById_AccelerationId(Long accelerationId);
}
