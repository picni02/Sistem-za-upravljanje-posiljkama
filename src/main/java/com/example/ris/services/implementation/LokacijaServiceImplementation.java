package com.example.ris.services.implementation;

import com.example.ris.models.entities.Filijala;
import com.example.ris.models.entities.Lokacija;
import com.example.ris.repositories.LokacijaRepository;
import com.example.ris.services.LokacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LokacijaServiceImplementation implements LokacijaService {

    @Autowired
    private LokacijaRepository _lokacijaRepository;

    @Override
    public List<Lokacija> getSveLokacije() {
        List<Lokacija> lokacije = _lokacijaRepository.getLokacije();
        return lokacije.stream().map(Lokacija::new).collect(Collectors.toList());
    }

    @Override
    public Lokacija getLokacijaByID(int idLokacije) {
        return _lokacijaRepository.getLokacijaById(idLokacije);
    }

    @Override
    public Lokacija dodajNovuLokaciju(Lokacija lokacija) {
        List<Lokacija> lokacije = this.getSveLokacije();
        Lokacija temp;
        try {
            temp = new Lokacija(lokacija);
            for(Lokacija l : lokacije) {
                if(l.getLokacijaID().equals(temp.getLokacijaID()) || l.getPostanski_broj().equals(temp.getPostanski_broj())){
                    throw new Exception("Lokacija/Poštanski broj već postoji");
                }
            }
            _lokacijaRepository.save(temp);
            return new Lokacija(temp);
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Lokacija editLokaciju(Lokacija lokacija) {
        Lokacija lokacijaEdit = new Lokacija(lokacija);
        _lokacijaRepository.save(lokacijaEdit);
        return new Lokacija(lokacijaEdit);
    }

    @Override
    public void deleteLocation(int idLokacije) {
        Lokacija lokacija = _lokacijaRepository.getLokacijaById(idLokacije);
        _lokacijaRepository.delete(lokacija);
    }
}
