package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccelerationService implements AccelerationServiceInterface {

    private final AccelerationRepository repository;

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
