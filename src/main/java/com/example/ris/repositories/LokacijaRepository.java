package com.example.ris.repositories;

import com.example.ris.models.entities.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LokacijaRepository extends JpaRepository<Lokacija, Integer> {
    @Query("SELECT l FROM Lokacija l WHERE l.LokacijaID = : idLokacije")
    Lokacija getLokacijaById(@Param("idLokacije") Integer idLokacije);
    @Query("SELECT l FROM Lokacija l")
    List<Lokacija> getLokacije();
}
