package com.example.ris.models.entities;

import javax.persistence.*;

@Entity
public class Zahtjev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ZahtjevID;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private boolean placeno;
    @Column
    private String dodatneInformacije;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KorisnikID")
    private User korisnik;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OkrugID")
    private Okrug okrug;

    public Zahtjev() {
    }

    public Zahtjev(Integer zahtjevID, boolean status, boolean placeno, String dodatneInformacije, User korisnik, Okrug okrug) {
        ZahtjevID = zahtjevID;
        this.status = status;
        this.placeno = placeno;
        this.dodatneInformacije = dodatneInformacije;
        this.korisnik = korisnik;
        this.okrug = okrug;
    }

    public Integer getZahtjevID() {
        return ZahtjevID;
    }

    public void setZahtjevID(Integer zahtjevID) {
        ZahtjevID = zahtjevID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
    }

    public String getDodatneInformacije() {
        return dodatneInformacije;
    }

    public void setDodatneInformacije(String dodatneInformacije) {
        this.dodatneInformacije = dodatneInformacije;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }

    public Okrug getOkrug() {
        return okrug;
    }

    public void setOkrug(Okrug okrug) {
        this.okrug = okrug;
    }
}
