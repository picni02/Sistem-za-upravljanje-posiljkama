package com.example.ris.repositories;

import com.example.ris.models.entities.Dostavljac;
import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Integer> {
    Radnik findByEmail(String email);

    @Query("SELECT r FROM Radnik r WHERE r.roleId = :roleId")
    List<Radnik> getRadniciByRole(@Param("roleId") int roleId);

    @Query("SELECT r FROM Radnik r WHERE r.idRadnika = :idRadnika")
    Radnik getRadnikById(@Param("idRadnika") int idRadnika);

    @Query("SELECT d FROM Dostavljac d WHERE d.roleId = 2")
    List<Dostavljac> getDostavljaci();
}
