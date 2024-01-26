package com.example.ris.services.implementation;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Posiljka;
import com.example.ris.models.entities.Status;
import com.example.ris.repositories.FilijalaRepository;
import com.example.ris.repositories.PosiljkaRepository;
import com.example.ris.services.PosiljkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosiljkaServiceImplementation implements PosiljkaService {
    @Autowired
    private PosiljkaRepository _posiljkaRepository;

    @Override
    public List<Posiljka> getSvePosiljkeFilijale(int idFilijale) {
        List<Posiljka> posiljke = _posiljkaRepository.getPosiljkeByFilijalaId(idFilijale);
        return posiljke.stream().map(Posiljka::new).collect(Collectors.toList());
    }

    @Override
    public List<Posiljka> getSvePosiljkeOkruga(int idOkruga) {
        List<Posiljka> posiljke = _posiljkaRepository.getPosiljkeByOkrugId(idOkruga);
        return posiljke.stream().map(Posiljka::new).collect(Collectors.toList());
    }

    @Override
    public List<Posiljka> getSveNeIsporucenePosiljke(Integer status) {
        List<Posiljka> posiljke = _posiljkaRepository.getPosiljkeByStatus(status);
        return posiljke.stream().map(Posiljka::new).collect(Collectors.toList());
    }

    @Override
    public Posiljka getPosiljkaByID(int idPosiljke) {
        return _posiljkaRepository.getPosiljkaById(idPosiljke);
    }

    @Override
    public Posiljka dodajNovuPosiljku(Posiljka posiljka) {
        List<Posiljka> posiljke = _posiljkaRepository.findAll();
        Posiljka temp;
        try {
            temp = new Posiljka(posiljka);
            for(Posiljka p : posiljke) {
                if(p.getIDposiljke().equals(temp.getIDposiljke())){
                    throw new Exception("Paket s tim ID-om već postoji");
                }
            }
            _posiljkaRepository.save(temp);
            return new Posiljka(temp);
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Posiljka editPosiljka(Posiljka posiljka) {
        Posiljka temp = new Posiljka(posiljka);
        _posiljkaRepository.save(temp);
        return new Posiljka(temp);
    }
}
