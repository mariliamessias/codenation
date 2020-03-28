package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM Users u " +
            "INNER JOIN Candidate c ON u.id = c.user_id " +
            "INNER JOIN Acceleration a on c.acceleration_id = a.id " +
            "WHERE a.name = :name", nativeQuery = true)
    List<User> findByAccelerationName(@Param("name") String name);

    @Query(value = "SELECT * FROM Users u " +
            "INNER JOIN Candidate c on u.id = c.user_id " +
            "INNER JOIN Company cp on c.company_id = cp.id " +
            "WHERE cp.id = :companyId", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}
