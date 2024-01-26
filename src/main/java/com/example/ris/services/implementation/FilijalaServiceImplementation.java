package com.example.ris.services.implementation;

import com.example.ris.models.entities.*;
import com.example.ris.repositories.*;
import com.example.ris.services.FilijalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilijalaServiceImplementation implements FilijalaService {

    @Autowired 
    private FilijalaRepository _FilijalaRepository;
    @Autowired
    private LokacijaRepository _lokacijaRepository;
    @Autowired
    private RadnikRepository _radnikRepository;
    @Autowired
    private VoziloRepository _voziloRepository;

    @Override
    public List<Filijala> getSveFilijale() {
        List<Filijala> filijale = _FilijalaRepository.findAll();
        return filijale.stream().map(Filijala::new).collect(Collectors.toList());
    }

    @Override
    public List<Okrug> getOkruziById(int id) {
        try {
            if(_FilijalaRepository.findById(id) == null) throw new Exception("Nema okruga.");
            Filijala temp = _FilijalaRepository.findById(id);
            List<Okrug> okruzi = temp.getOkruzi();
            return okruzi.stream().map(Okrug::new).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Radnik> getDostavljaciById(int id) {
        try {
            if(_radnikRepository.findAll() == null) throw new Exception("Nema dostavljača.");
            Filijala temp = _FilijalaRepository.findById(id);
            List<Radnik> dostavljaci = _radnikRepository.getRadniciByRole(2);
            return dostavljaci.stream().map(Radnik::new).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Lokacija> getLokacije() {
        List<Lokacija> lokacije = _lokacijaRepository.getLokacije();
        return lokacije.stream().map(Lokacija::new).collect(Collectors.toList());
    }

    @Override
    public List<Vozilo> getVozila() {
        try {
            if(_voziloRepository.findAll() == null) throw new Exception("Nema vozila.");
            List<Vozilo> vozila = _voziloRepository.getVozila();
            return vozila.stream().map(Vozilo::new).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Posiljka> getPosiljkeByIdFilijale(int id) {
        try {
            if(_FilijalaRepository.findById(id) == null) throw new Exception("Nema pošiljki.");
            Filijala temp = this.getSveFilijale().get(id);
            List<Posiljka> posiljke = _FilijalaRepository.getPosiljke(temp.getFilijalaID());
            return posiljke.stream().map(Posiljka::new).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Filijala dodajNovuFilijalu(Filijala filijala) {
        List<Filijala> filijale = this.getSveFilijale();
        Filijala temp;
        try {
            temp = new Filijala(filijala);
            for(Filijala f : filijale) {
                if(f.getFilijalaID().equals(temp.getFilijalaID())){
                    throw new Exception("Filijala već postoji");
                }
            }
            _FilijalaRepository.save(temp);
            return new Filijala(temp);
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Filijala editFilijala(Filijala filijala) {
        Filijala temp = new Filijala(filijala);
        _FilijalaRepository.save(temp);
        return new Filijala(temp);
    }

    @Override
    public void deleteFilijala(int id){
        Filijala temp = _FilijalaRepository.findById(id);
        _FilijalaRepository.delete(temp);
    }
}
