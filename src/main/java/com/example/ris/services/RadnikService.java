package com.example.ris.services;

import com.example.ris.models.entities.Dostavljac;
import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.User;

import java.util.List;

public interface RadnikService {
    public List<Radnik> getSviRadnici();
    public Radnik getRadnikByEmail(String username);
    public Radnik getRadnikById(Integer idRadnika);
    public List<Dostavljac> getDostavljaci();
    public Radnik registerRadnik(Radnik radnik);
    public Radnik editRadnik(Radnik radnik);
    public void deleteRadnik(int idRadnika);
}
