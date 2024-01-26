package com.example.ris.repositories;

import com.example.ris.models.entities.Status;
import com.example.ris.models.entities.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipRepository extends JpaRepository<Tip, Integer> {
    @Query("SELECT t FROM Tip t")
    List<Tip> getTipovi();
}
