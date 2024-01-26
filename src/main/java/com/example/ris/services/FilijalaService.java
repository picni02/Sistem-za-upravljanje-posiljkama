package com.example.ris.services;

import com.example.ris.models.entities.*;

import java.util.List;

public interface FilijalaService {
    public List<Filijala> getSveFilijale();
    public List<Okrug> getOkruziById(int id);
    public List<Radnik> getDostavljaciById(int id);
    public List<Lokacija> getLokacije();
    public List<Vozilo> getVozila();
    public List<Posiljka> getPosiljkeByIdFilijale(int id);
    public Filijala dodajNovuFilijalu(Filijala filijala);
    public Filijala editFilijala(Filijala filijala);
    public void deleteFilijala(int id);
}
