package com.example.ris.models.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Dostavljac extends Radnik{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OkrugID")
    private Okrug okrug;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FilijalaID")
    private Filijala filijala;

    @OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
    private List<Posiljka> posiljke;

    public Dostavljac() {
    }

    public Dostavljac(Integer idRadnika, String firstName, String lastName, Date datum_rodjenja, String email, String password, String spol, String broj_telefona, String adresa, Date datum_zaposlenja, Integer roleId, Okrug okrug, Filijala filijala) {
        super(idRadnika, firstName, lastName, datum_rodjenja, email, password, spol, broj_telefona, adresa, datum_zaposlenja, roleId);
        this.okrug = okrug;
        this.filijala = filijala;
    }

    public Dostavljac(Okrug okrug, Filijala filijala, List<Posiljka> posiljke) {
        this.okrug = okrug;
        this.filijala = filijala;
        this.posiljke = posiljke;
    }

    public Dostavljac(Dostavljac dostavljac) {
        Radnik radnik = new Radnik(dostavljac);
        this.okrug = dostavljac.getOkrug();
        this.filijala = dostavljac.getFilijala();
        this.posiljke = dostavljac.getPosiljke();
    }

    public Okrug getOkrug() {
        return okrug;
    }

    public void setOkrug(Okrug okrug) {
        this.okrug = okrug;
    }

    public Filijala getFilijala() {
        return filijala;
    }

    public void setFilijala(Filijala filijala) {
        this.filijala = filijala;
    }

    public List<Posiljka> getPosiljke() {
        return posiljke;
    }

    public void setPosiljke(List<Posiljka> posiljke) {
        this.posiljke = posiljke;
    }
}
