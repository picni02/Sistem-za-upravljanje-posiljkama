package com.example.ris.repositories;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoziloRepository extends JpaRepository<Vozilo, Integer> {
    @Query("SELECT v FROM Vozilo v WHERE v.VoziloID = :idVozila")
    Vozilo getVoziloById(@Param("idVozila") Integer idVozila);
    @Query("SELECT v FROM Vozilo v")
    List<Vozilo> getVozila();
}
