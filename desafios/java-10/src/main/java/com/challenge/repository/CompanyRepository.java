package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT DISTINCT co FROM Company co " +
            "INNER JOIN Candidate ca ON co = ca.id.company " +
            "WHERE ca.id.acceleration.id = :acceleration_id")
    List<Company> findByAccelerationId(@Param("acceleration_id") Long accelerationId);

    @Query(value = "SELECT * from Company co " +
            "INNER JOIN Candidate c on co.id = c.company_id " +
            "INNER JOIN Users u on c.user_id = u.id WHERE u.id = :userId", nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);
}
