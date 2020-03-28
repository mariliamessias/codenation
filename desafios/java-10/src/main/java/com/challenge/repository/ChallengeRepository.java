package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query("SELECT ch FROM Challenge ch " +
            "INNER JOIN Acceleration a ON ch =a.challenge " +
            "INNER JOIN Candidate ca ON a = ca.id.acceleration " +
            "WHERE a.id = :acceleration_id AND ca.id.user.id = :user_id")
    List<Challenge> findByAccelerationIdAndUserId(@Param("acceleration_id") Long accelerationId, @Param("user_id") Long userId);
}
