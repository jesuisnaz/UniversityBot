package com.nklymok.university.service;

import com.nklymok.university.model.lector.Lector;

import java.util.List;

public interface LectorService {

    List<Lector> findAll();

    List<Lector> findByNamePattern(String pattern);

    Lector save(Lector lector);

}
