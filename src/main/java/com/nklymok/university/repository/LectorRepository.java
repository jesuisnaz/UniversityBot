package com.nklymok.university.repository;

import com.nklymok.university.model.lector.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findByFullNameContaining(String pattern);

}
