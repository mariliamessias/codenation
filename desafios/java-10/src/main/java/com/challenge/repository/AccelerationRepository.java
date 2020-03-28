package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Acceleration findAccelerationByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Acceleration " +
            "INNER JOIN Candidate on acceleration.id = candidate.acceleration_id " +
            "INNER JOIN Company on candidate.company_id = company.id " +
            "WHERE company.id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
