package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Regija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RegijaID;

    @Column(nullable = false)
    @Size(max = 100)
    private String nazivRegije;

    @OneToOne
    @JoinColumn(name = "idRadnika", unique = true)
    private Superadmin superadmin;

    @OneToMany(mappedBy = "regija", cascade = CascadeType.ALL)
    private List<Filijala> filijale;

    public Regija() {
    }

    public Regija(Regija regija) {
        this.RegijaID = regija.getRegijaID();
        this.nazivRegije = regija.getNazivRegije();
        this.superadmin = regija.getSuperadmin();
        this.filijale = regija.getFilijale();
    }

    public Integer getRegijaID() {
        return RegijaID;
    }

    public void setRegijaID(Integer regijaID) {
        RegijaID = regijaID;
    }

    public String getNazivRegije() {
        return nazivRegije;
    }

    public void setNazivRegije(String nazivRegije) {
        this.nazivRegije = nazivRegije;
    }

    public Superadmin getSuperadmin() {
        return superadmin;
    }

    public void setSuperadmin(Superadmin superadmin) {
        this.superadmin = superadmin;
    }

    public List<Filijala> getFilijale() {
        return filijale;
    }

    public void setFilijale(List<Filijala> filijale) {
        this.filijale = filijale;
    }
}
