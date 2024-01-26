package com.example.ris.repositories;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Okrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OkrugRepository extends JpaRepository<Okrug, Integer> {

    @Query("SELECT o FROM Okrug o WHERE o.OkrugID = : idOkruga")
    Okrug getOkrugById(@Param("idOkruga") Integer idOkruga);

    @Query("SELECT o FROM Okrug o WHERE o.filijala.FilijalaID = :idFilijale")
    Okrug getOkrugByIdFilijale(@Param("idFilijale") Integer idFilijale);

    @Query("SELECT o FROM Okrug o WHERE o.filijala.FilijalaID = 1")
    List<Okrug> getOkruzi();
}
