package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("FROM Challenge challenge " +
            "JOIN challenge.accelerations accelerations " +
            "JOIN accelerations.candidates candidate " +
            "JOIN candidate.id.user user " +
            "WHERE accelerations.id = :accelerationId " +
            "AND user.id = :userId")
    List<Challenge> findByAccelerationIdAndUserId(
            @Param("accelerationId") Long accelerationId,
            @Param("userId") Long userId);

}
