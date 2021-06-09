package com.nklymok.university.service.impl;

import com.nklymok.university.model.lector.Lector;
import com.nklymok.university.repository.LectorRepository;
import com.nklymok.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorServiceImpl implements LectorService {

    private final LectorRepository repository;

    @Autowired
    public LectorServiceImpl(LectorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Lector> findAll() {
        return repository.findAll();
    }

    @Override
    public Lector save(Lector lector) {
        return repository.save(lector);
    }

    @Override
    public List<Lector> findByNamePattern(String pattern) {
        return repository.findByFullNameContaining(pattern);
    }

}
