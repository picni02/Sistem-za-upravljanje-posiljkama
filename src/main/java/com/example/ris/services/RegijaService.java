package com.example.ris.services;

import com.example.ris.models.entities.*;

import java.util.List;

public interface RegijaService {
    public List<Filijala> getSveFilijaleRegije(int id);
    public List<Regija> getSveRegije();

    public Superadmin getSuperadmin(int id);
    public Regija dodajNovuRegiju(Regija regija);
    public Regija editRegija(Regija regija);
    public void deleteRegija(int id);
}
