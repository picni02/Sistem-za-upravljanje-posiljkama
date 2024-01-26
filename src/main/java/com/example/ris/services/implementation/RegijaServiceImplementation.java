package com.example.ris.services.implementation;

import com.example.ris.models.entities.*;
import com.example.ris.repositories.RegijaRepository;
import com.example.ris.services.RegijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegijaServiceImplementation implements RegijaService {

    @Autowired 
    private RegijaRepository _RegijaRepository;


    @Override
    public List<Filijala> getSveFilijaleRegije(int id){
        Regija reg = _RegijaRepository.findById(id);
        List<Filijala> filijale = reg.getFilijale();
        return filijale.stream().map(Filijala::new).collect(Collectors.toList());
    }

    @Override
    public List<Regija> getSveRegije(){
        return _RegijaRepository.findAll().stream().toList();
    }

    @Override
    public Superadmin getSuperadmin(int id){
        Regija temp = _RegijaRepository.findById(id);
        return temp.getSuperadmin();
    }


    @Override
    public Regija dodajNovuRegiju(Regija regija) {
        List<Regija> regije = this.getSveRegije();
        Regija reg;
        try {
            reg = new Regija(regija);
            for(Regija r : regije) {
                if(r.getRegijaID().equals(reg.getRegijaID())){
                    throw new Exception("Regija sa tim ID-om već postoji");
                }
            }
            _RegijaRepository.save(reg);
            return new Regija(reg);
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Regija editRegija(Regija regija) {
        Regija temp = new Regija(regija);
        _RegijaRepository.save(temp);
        return new Regija(temp);
    }

    @Override
    public void deleteRegija(int id){
        Regija temp = _RegijaRepository.findById(id);
        _RegijaRepository.delete(temp);
    }
}
