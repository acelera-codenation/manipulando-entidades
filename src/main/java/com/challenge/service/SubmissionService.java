package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class SubmissionService implements SubmissionServiceInterface {

    private final SubmissionRepository repository;

    @Autowired
    public SubmissionService(SubmissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return repository.findHigherScoreByChallengeId(challengeId).orElse(BigDecimal.ZERO);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return repository.save(object);
    }
}
