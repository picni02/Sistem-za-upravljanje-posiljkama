package com.example.ris.services;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.User;

import java.util.List;

public interface LokacijaService {
    public List<Lokacija> getSveLokacije();
    public Lokacija getLokacijaByID(int idLokacije);
    public Lokacija dodajNovuLokaciju(Lokacija lokacija);
    public Lokacija editLokaciju(Lokacija lokacija);
    public void deleteLocation(int idLokacije);
}
