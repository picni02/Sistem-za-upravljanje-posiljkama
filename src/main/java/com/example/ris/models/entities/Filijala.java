package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Filijala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FilijalaID;

    @Column(nullable = false)
    @Size(max = 100)
    private String nazivFilijale;

    @Column(nullable = false)
    @Size(max = 100)
    private String adresaFilijale;

    @OneToOne
    @JoinColumn(name = "idRadnika", unique = true)
    private Admin admin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RegijaID")
    private Regija regija;

    @OneToMany(mappedBy = "filijala", cascade = CascadeType.ALL)
    private List<Okrug> okruzi;

    @OneToMany(mappedBy = "filijala", cascade = CascadeType.ALL)
    private List<Vozilo> vozila;

    @OneToMany(mappedBy = "filijala", cascade = CascadeType.ALL)
    private List<Dostavljac> dostavljaci;

    public Filijala() {
    }

    public Filijala(Integer filijalaID, String nazivFilijale, String adresaFilijale, Admin admin, Regija regija, List<Okrug> okruzi, List<Vozilo> vozila, List<Dostavljac> dostavljaci) {
        FilijalaID = filijalaID;
        this.nazivFilijale = nazivFilijale;
        this.adresaFilijale = adresaFilijale;
        this.admin = admin;
        this.regija = regija;
        this.okruzi = okruzi;
        this.vozila = vozila;
        this.dostavljaci = dostavljaci;
    }

    public Filijala(Filijala filijala) {
        FilijalaID = filijala.getFilijalaID();
        this.nazivFilijale = filijala.getNazivFilijale();
        this.adresaFilijale = filijala.getAdresaFilijale();
        this.admin = filijala.getAdmin();
        this.regija = filijala.getRegija();
        this.okruzi = filijala.getOkruzi();
        this.vozila = filijala.getVozila();
        this.dostavljaci = filijala.getDostavljaci();
    }

    public Integer getFilijalaID() {
        return FilijalaID;
    }

    public void setFilijalaID(Integer filijalaID) {
        FilijalaID = filijalaID;
    }

    public String getNazivFilijale() {
        return nazivFilijale;
    }

    public void setNazivFilijale(String nazivFilijale) {
        this.nazivFilijale = nazivFilijale;
    }

    public String getAdresaFilijale() {
        return adresaFilijale;
    }

    public void setAdresaFilijale(String adresaFilijale) {
        this.adresaFilijale = adresaFilijale;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Regija getRegija() {
        return regija;
    }

    public void setRegija(Regija regija) {
        this.regija = regija;
    }

    public List<Okrug> getOkruzi() {
        return okruzi;
    }

    public void setOkruzi(List<Okrug> okruzi) {
        this.okruzi = okruzi;
    }

    public List<Vozilo> getVozila() {
        return vozila;
    }

    public void setVozila(List<Vozilo> vozila) {
        this.vozila = vozila;
    }

    public List<Dostavljac> getDostavljaci() {
        return dostavljaci;
    }

    public void setDostavljaci(List<Dostavljac> dostavljaci) {
        this.dostavljaci = dostavljaci;
    }

}
