package com.example.ris.services;

import com.example.ris.models.entities.Okrug;
import com.example.ris.models.entities.Vozilo;

import java.util.List;

public interface OkrugService {

    public List<Okrug> getSviOkruzi();
    public Okrug getOkrugByID(int idOkruga);
    public Okrug getOkrugByIDFilijale(int idFilijale);
    public Okrug dodajNoviOkrug(Okrug okrug);
    public Okrug editOkrug(Okrug okrug);
    public void deleteOkrug(int idOkruga);
}
