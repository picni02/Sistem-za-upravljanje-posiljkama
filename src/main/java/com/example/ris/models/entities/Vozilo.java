package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Vozilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer VoziloID;

    @Column(nullable = false, unique = true)
    @Size(max = 20)
    private String registarske_oznake;

    @Column
    private boolean status;

    @OneToOne
    @JoinColumn(name = "idRadnika", unique = true)
    private Dostavljac dostavljac;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FilijalaID")
    private Filijala filijala;

    @OneToMany(mappedBy = "vozilo", cascade = CascadeType.ALL)
    private List<Kvar> kvarovi;

    public Vozilo() {
    }

    public Vozilo(Integer voziloID, String registarske_oznake, boolean status, Dostavljac dostavljac, Filijala filijala, List<Kvar> kvarovi) {
        VoziloID = voziloID;
        this.registarske_oznake = registarske_oznake;
        this.status = status;
        this.dostavljac = dostavljac;
        this.filijala = filijala;
        this.kvarovi = kvarovi;
    }

    public Vozilo(Vozilo vozilo) {
        VoziloID = vozilo.getVoziloID();
        this.registarske_oznake = vozilo.getRegistarske_oznake();
        this.status = vozilo.isStatus();
        this.dostavljac = vozilo.getDostavljac();
        this.filijala = vozilo.getFilijala();
        this.kvarovi = vozilo.getKvarovi();
    }

    public Integer getVoziloID() {
        return VoziloID;
    }

    public void setVoziloID(Integer voziloID) {
        VoziloID = voziloID;
    }

    public String getRegistarske_oznake() {
        return registarske_oznake;
    }

    public void setRegistarske_oznake(String registarske_oznake) {
        this.registarske_oznake = registarske_oznake;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public Filijala getFilijala() {
        return filijala;
    }

    public void setFilijala(Filijala filijala) {
        this.filijala = filijala;
    }

    public List<Kvar> getKvarovi() {
        return kvarovi;
    }

    public void setKvarovi(List<Kvar> kvarovi) {
        this.kvarovi = kvarovi;
    }

}
