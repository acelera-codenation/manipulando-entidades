package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT company FROM Company company " +
            "JOIN company.candidates candidate " +
            "WHERE candidate.id.user.id = :userId")
    List<Company> findByIdUserId(@Param("userId") Long userId);

    @Query("SELECT distinct company FROM Company company " +
            "JOIN company.candidates candidate " +
            "WHERE candidate.id.acceleration.id = :accelerationId")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);


}
