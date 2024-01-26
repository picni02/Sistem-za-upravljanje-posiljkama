package com.example.ris.repositories;

import com.example.ris.models.entities.Filijala;
import com.example.ris.models.entities.Posiljka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilijalaRepository extends JpaRepository<Filijala, Integer> {
    Filijala findById(int id);
    @Query("SELECT p FROM Okrug o JOIN o.posiljke p WHERE o.filijala.FilijalaID = :idFilijale")
    List<Posiljka> getPosiljke(@Param("idFilijale") Integer idFilijale);
}
