package com.example.ris.services.implementation;

import com.example.ris.models.entities.Dostavljac;
import com.example.ris.models.entities.Filijala;
import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.User;
import com.example.ris.repositories.RadnikRepository;
import com.example.ris.repositories.UserRepository;
import com.example.ris.services.RadnikService;
import com.example.ris.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RadnikServiceImplementation implements RadnikService {

    @Autowired
    private RadnikRepository _RadnikRepository;

    @Autowired
    private PasswordEncoder _PasswordEncoder;

    @Override
    public List<Radnik> getSviRadnici() {
        List<Radnik> radnici = _RadnikRepository.findAll();
        return radnici.stream().map(Radnik::new).collect(Collectors.toList());
    }

    public Radnik getRadnikByEmail(String username) {
        return _RadnikRepository.findByEmail(username);
    }

    @Override
    public Radnik getRadnikById(Integer idRadnika) {
        return _RadnikRepository.getRadnikById(idRadnika);
    }

    @Override
    public List<Dostavljac> getDostavljaci() {
        List<Dostavljac> dostavljaci = _RadnikRepository.getDostavljaci();
        return dostavljaci.stream().map(Dostavljac::new).collect(Collectors.toList());
    }

    @Override
    public Radnik registerRadnik(Radnik radnik) {
        List<Radnik> radnici = this.getSviRadnici();
        Radnik temp;
        try {
            temp = new Radnik(radnik);
            for(Radnik r : radnici) if(r.getEmail().equals(temp.getEmail()) || r.getIdRadnika().equals(temp.getIdRadnika())) throw new Exception("Radnik već postoji");
            temp.setPassword(_PasswordEncoder.encode(temp.getPassword()));
            _RadnikRepository.save(temp);
            return new Radnik(temp);
        } catch (Exception e) {}
        return null;
    }

    @Override
    public Radnik editRadnik(Radnik radnik) {
        Radnik temp = new Radnik(radnik);
        _RadnikRepository.save(temp);
        return new Radnik(temp);
    }

    @Override
    public void deleteRadnik(int idRadnika) {
        Radnik radnik = _RadnikRepository.getRadnikById(idRadnika);
        _RadnikRepository.delete(radnik);
    }
}
