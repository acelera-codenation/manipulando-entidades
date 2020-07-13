package com.challenge.service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidateService implements CandidateServiceInterface {

    private final CandidateRepository repository;

    @Autowired
    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return repository.findByUserIdAndCompanyIdAndAccelarationId(
                id.getUser().getId(), id.getCompany().getId(), id.getAcceleration().getId());
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return repository.findByUserIdAndCompanyIdAndAccelarationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return repository.findByAccelerationId(accelerationId);
    }

    @Override
    public Candidate save(Candidate object) {
        return null;
    }
}
