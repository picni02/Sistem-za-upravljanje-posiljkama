package com.example.ris.services.implementation;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.Vozilo;
import com.example.ris.repositories.RadnikRepository;
import com.example.ris.repositories.VoziloRepository;
import com.example.ris.services.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoziloServiceImplementation implements VoziloService {

    @Autowired
    private VoziloRepository _voziloRepository;
    @Autowired
    private RadnikRepository _radnikRepository;

    @Override
    public List<Vozilo> getSvaVozila() {
        List<Vozilo> vozila = _voziloRepository.getVozila();
        return vozila.stream().map(Vozilo::new).collect(Collectors.toList());
    }

    @Override
    public Vozilo getVoziloByID(int idVozila) {
        return _voziloRepository.getVoziloById(idVozila);
    }

    @Override
    public Vozilo getVoziloByEmailRadnika(String email) {
        Radnik radnik = _radnikRepository.findByEmail(email);
        List<Vozilo> vozila = _voziloRepository.getVozila();
        for(Vozilo v : vozila){
            if(v.getDostavljac().getIdRadnika().equals(radnik.getIdRadnika())){
                return v;
            }
        }
        return null;
    }

    @Override
    public Vozilo dodajNovoVozilo(Vozilo vozilo) {
        List<Vozilo> vozila = this.getSvaVozila();
        Vozilo temp;
        try {
            temp = new Vozilo(vozilo);
            for(Vozilo v : vozila) {
                if(v.getVoziloID().equals(temp.getVoziloID()) || v.getRegistarske_oznake().equals(temp.getRegistarske_oznake())){
                    throw new Exception("ID/Registarske oznake su već unesene");
                }
            }
            _voziloRepository.save(temp);
            return new Vozilo(temp);
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Vozilo editVozilo(Vozilo vozilo) {
        Vozilo temp = new Vozilo(vozilo);
        _voziloRepository.save(temp);
        return new Vozilo(temp);
    }

    @Override
    public void deleteVozilo(int idVozila) {
        Vozilo vozilo = _voziloRepository.getVoziloById(idVozila);
        _voziloRepository.delete(vozilo);
    }
}
