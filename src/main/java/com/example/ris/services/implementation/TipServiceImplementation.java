package com.example.ris.services.implementation;

import com.example.ris.models.entities.Status;
import com.example.ris.models.entities.Tip;
import com.example.ris.repositories.TipRepository;
import com.example.ris.services.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipServiceImplementation implements TipService {
    @Autowired
    private TipRepository _tipRepository;


    @Override
    public List<Tip> getTipovi() {
        List<Tip> tipovi = _tipRepository.getTipovi();
        return tipovi.stream().map(Tip::new).collect(Collectors.toList());
    }
}
