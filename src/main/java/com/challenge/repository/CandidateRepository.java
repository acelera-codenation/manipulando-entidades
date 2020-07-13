package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query("FROM Candidate candidate " +
            "WHERE candidate.id.user.id = :userId " +
            "AND candidate.id.company.id = :companyId " +
            "AND candidate.id.acceleration.id = :accelerationId")
    Optional<Candidate> findByUserIdAndCompanyIdAndAccelarationId(
            @Param("userId") Long userId,
            @Param("companyId") Long companyId,
            @Param("accelerationId") Long accelerationId);

    @Query("FROM Candidate candidate " +
            "WHERE candidate.id.company.id = :companyId")
    List<Candidate> findByCompanyId(Long companyId);

    @Query("FROM Candidate candidate " +
            "WHERE candidate.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(Long accelerationId);
}
