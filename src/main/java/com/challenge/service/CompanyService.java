package com.challenge.service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService implements CompanyServiceInterface {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return repository.findDistinctByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return repository.findByCandidatesIdUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return repository.save(object);
    }
}
