package com.example.ris.services;

import com.example.ris.models.entities.Posiljka;
import com.example.ris.models.entities.Status;
import com.example.ris.models.entities.Vozilo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PosiljkaService {
    public List<Posiljka> getSvePosiljkeFilijale(int idFilijale);
    public List<Posiljka> getSvePosiljkeOkruga(int idOkruga);
    public List<Posiljka> getSveNeIsporucenePosiljke(Integer status);
    public Posiljka getPosiljkaByID(int idPosiljke);
    public Posiljka dodajNovuPosiljku(Posiljka posiljka);
    public Posiljka editPosiljka(Posiljka posiljka);
}
