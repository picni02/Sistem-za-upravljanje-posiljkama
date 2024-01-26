package com.example.ris.repositories;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Integer> {

    @Query("SELECT s FROM Status s")
    List<Status> getStatusi();
}
