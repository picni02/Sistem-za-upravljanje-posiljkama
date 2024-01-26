package com.example.ris.repositories;

import com.example.ris.models.entities.Filijala;
import com.example.ris.models.entities.Regija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegijaRepository extends JpaRepository<Regija, Integer> {
    Regija findById(int id);
}
