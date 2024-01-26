package com.example.ris.services.implementation;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Okrug;
import com.example.ris.repositories.OkrugRepository;
import com.example.ris.services.OkrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OkrugServiceImplementation implements OkrugService {

    @Autowired
    private OkrugRepository _okrugRepository;
    @Override
    public List<Okrug> getSviOkruzi() {
        List<Okrug> okruzi = _okrugRepository.getOkruzi();
        return okruzi.stream().map(Okrug::new).collect(Collectors.toList());
    }

    @Override
    public Okrug getOkrugByID(int idOkruga) {
        return _okrugRepository.getOkrugById(idOkruga);
    }

    @Override
    public Okrug getOkrugByIDFilijale(int idFilijale) {
        return _okrugRepository.getOkrugByIdFilijale(idFilijale);
    }

    @Override
    public Okrug dodajNoviOkrug(Okrug okrug) {
        List<Okrug> okruzi = this.getSviOkruzi();
        Okrug temp;
        try {
            temp = new Okrug(okrug);
            for(Okrug o : okruzi) {
                if(o.getOkrugID().equals(temp.getOkrugID())){
                    throw new Exception("Okrug sa tim ID-om već postoji");
                }
            }
            _okrugRepository.save(temp);
            return new Okrug(temp);
        } catch (Exception e) {}

        return null;
    }

    @Override
    public Okrug editOkrug(Okrug okrug) {
        Okrug temp = new Okrug(okrug);
        _okrugRepository.save(temp);
        return new Okrug(temp);
    }

    @Override
    public void deleteOkrug(int idOkruga) {
        Okrug okrug = _okrugRepository.getOkrugById(idOkruga);
        _okrugRepository.delete(okrug);
    }
}
