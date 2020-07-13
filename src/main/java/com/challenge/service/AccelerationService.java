package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccelerationService implements AccelerationServiceInterface {

    private final AccelerationRepository repository;

    @Autowired
    public AccelerationService(AccelerationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Acceleration> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Acceleration> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return repository.save(object);
    }
}
