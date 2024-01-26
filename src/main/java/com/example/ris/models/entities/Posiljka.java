package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Posiljka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDposiljke;

    @Column(nullable = false)
    @Size(max = 10)
    private Double tezina;

    @Column(nullable = false)
    @Size(max = 10)
    private Double cijena;

    @Column(nullable = false)
    @Size(max = 100)
    private String adresaPosiljaoca;

    @Column(nullable = false)
    @Size(max = 100)
    private String adresaPrimaoca;

    @Column(nullable = false)
    private Boolean prio;

    @Column(nullable = false)
    private Integer FilijalaID;
    @Column
    private String dodatneInformacije;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TipID")
    private Tip tip;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "StatusID")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsera")
    private User korisnik;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRadnika")
    private Dostavljac dostavljac;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OkrugID")
    private Okrug okrug;

    public Posiljka() {
    }

    public Posiljka(Integer IDposiljke, Double tezina, Double cijena, String adresaPosiljaoca, String adresaPrimaoca, Boolean prio, Integer filijalaID, String dodatneInformacije, Tip tip, Status status, User korisnik, Dostavljac dostavljac, Okrug okrug) {
        this.IDposiljke = IDposiljke;
        this.tezina = tezina;
        this.cijena = cijena;
        this.adresaPosiljaoca = adresaPosiljaoca;
        this.adresaPrimaoca = adresaPrimaoca;
        this.prio = prio;
        FilijalaID = filijalaID;
        this.dodatneInformacije = dodatneInformacije;
        this.tip = tip;
        this.status = status;
        this.korisnik = korisnik;
        this.dostavljac = dostavljac;
        this.okrug = okrug;
    }

    public Posiljka(Posiljka posiljka) {
        this.IDposiljke = posiljka.getIDposiljke();
        this.tezina = posiljka.getTezina();
        this.cijena = posiljka.getCijena();
        this.prio = posiljka.getPrio();
        this.tip = posiljka.getTip();
        this.adresaPosiljaoca = posiljka.getAdresaPosiljaoca();
        this.adresaPrimaoca = posiljka.getAdresaPrimaoca();
        this.status = posiljka.getStatus();
        this.korisnik = posiljka.getKorisnik();
        this.dostavljac = posiljka.getDostavljac();
        this.okrug = posiljka.getOkrug();
        this.dodatneInformacije = posiljka.getDodatneInformacije();
        this.FilijalaID = posiljka.getFilijalaID();
    }

    public Integer getIDposiljke() {
        return IDposiljke;
    }

    public void setIDposiljke(Integer IDposiljke) {
        this.IDposiljke = IDposiljke;
    }

    public Double getTezina() {
        return tezina;
    }

    public void setTezina(Double tezina) {
        this.tezina = tezina;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public Boolean getPrio() {
        return prio;
    }

    public void setPrio(Boolean prio) {
        this.prio = prio;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public String getAdresaPosiljaoca() {
        return adresaPosiljaoca;
    }

    public void setAdresaPosiljaoca(String adresaPosiljaoca) {
        this.adresaPosiljaoca = adresaPosiljaoca;
    }

    public String getAdresaPrimaoca() {
        return adresaPrimaoca;
    }

    public void setAdresaPrimaoca(String adresaPrimaoca) {
        this.adresaPrimaoca = adresaPrimaoca;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public Okrug getOkrug() {
        return okrug;
    }

    public void setOkrug(Okrug okrug) {
        this.okrug = okrug;
    }

    public Integer getFilijalaID() {
        return FilijalaID;
    }

    public void setFilijalaID(Integer filijalaID) {
        FilijalaID = filijalaID;
    }

    public String getDodatneInformacije() {
        return dodatneInformacije;
    }

    public void setDodatneInformacije(String dodatneInformacije) {
        this.dodatneInformacije = dodatneInformacije;
    }
}
