package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Okrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OkrugID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LokacijaID")
    private Lokacija lokacija;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FilijalaID")
    private Filijala filijala;

    @OneToMany(mappedBy = "okrug", cascade = CascadeType.ALL)
    private List<Dostavljac> dostavljaci;

    @OneToMany(mappedBy = "okrug", cascade = CascadeType.ALL)
    private List<Posiljka> posiljke;
    @OneToMany(mappedBy = "okrug", cascade = CascadeType.ALL)
    private List<Zahtjev> zahtjevi;


    public Okrug() {
    }

    public Okrug(Integer okrugID, Lokacija lokacija, Filijala filijala, List<Dostavljac> dostavljaci, List<Posiljka> posiljke, List<Zahtjev> zahtjevi) {
        OkrugID = okrugID;
        this.lokacija = lokacija;
        this.filijala = filijala;
        this.dostavljaci = dostavljaci;
        this.posiljke = posiljke;
        this.zahtjevi = zahtjevi;
    }

    public Okrug(Okrug okrug) {
        OkrugID = okrug.getOkrugID();
        this.lokacija = okrug.getLokacija();
        this.filijala = okrug.getFilijala();
        this.dostavljaci = okrug.getDostavljaci();
        this.posiljke = okrug.getPosiljke();
        this.zahtjevi = okrug.getZahtjevi();
    }

    public Integer getOkrugID() {
        return OkrugID;
    }

    public void setOkrugID(Integer okrugID) {
        OkrugID = okrugID;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Filijala getFilijala() {
        return filijala;
    }

    public void setFilijala(Filijala filijala) {
        this.filijala = filijala;
    }

    public List<Dostavljac> getDostavljaci() {
        return dostavljaci;
    }

    public void setDostavljaci(List<Dostavljac> dostavljaci) {
        this.dostavljaci = dostavljaci;
    }

    public List<Posiljka> getPosiljke() {
        return posiljke;
    }

    public void setPosiljke(List<Posiljka> posiljke) {
        this.posiljke = posiljke;
    }

    public List<Zahtjev> getZahtjevi() {
        return zahtjevi;
    }

    public void setZahtjevi(List<Zahtjev> zahtjevi) {
        this.zahtjevi = zahtjevi;
    }
}
