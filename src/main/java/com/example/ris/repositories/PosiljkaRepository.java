package com.example.ris.repositories;

import com.example.ris.models.entities.Posiljka;
import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosiljkaRepository extends JpaRepository<Posiljka, Integer> {
    @Query("SELECT p FROM Filijala f JOIN f.okruzi o join o.posiljke p")
    List<Posiljka> getSvePosiljke();
    @Query("SELECT p FROM Posiljka p WHERE p.IDposiljke = :idPosiljke")
    Posiljka getPosiljkaById(@Param("idPosiljke") int idPosiljke);

    @Query("SELECT p FROM Okrug o JOIN o.posiljke p WHERE o.OkrugID = :idOkruga")
    List<Posiljka> getPosiljkeByOkrugId(@Param("idOkruga") int idOkruga);

    @Query("SELECT p FROM Posiljka p WHERE p.FilijalaID = :idFilijale")
    List<Posiljka> getPosiljkeByFilijalaId(@Param("idFilijale") int idFilijale);

    @Query("SELECT p FROM Okrug o JOIN o.posiljke p WHERE p.status = :status")
    List<Posiljka> getPosiljkeByStatus(@Param("status") Integer status);
}
