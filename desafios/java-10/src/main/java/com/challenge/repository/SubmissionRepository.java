package com.challenge.repository;

import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    Optional<Submission> findFirstById_ChallengeIdOrderByScoreDesc(Long challengeId);

    @Query("SELECT s FROM Submission s " +
            "INNER JOIN Challenge c ON c = s.id.challenge " +
            "INNER JOIN Acceleration a ON c = a.challenge " +
            "WHERE c.id = :challenge_id AND a.id = :acceleration_id")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challenge_id") Long challengeId, @Param("acceleration_id") Long accelerationId);

}

