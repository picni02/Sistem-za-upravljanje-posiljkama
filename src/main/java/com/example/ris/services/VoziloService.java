package com.example.ris.services;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Vozilo;

import java.util.List;

public interface VoziloService {
    public List<Vozilo> getSvaVozila();
    public Vozilo getVoziloByID(int idVozila);
    public Vozilo getVoziloByEmailRadnika(String email);
    public Vozilo dodajNovoVozilo(Vozilo vozilo);
    public Vozilo editVozilo(Vozilo vozilo);
    public void deleteVozilo(int idVozila);
}
