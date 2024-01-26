package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Kvar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer KvarID;

    @Column(nullable = false)
    @Size(max = 255)
    private String opis_kvara;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VoziloID")
    private Vozilo vozilo;

    public Kvar() {
    }

    public Kvar(Integer kvarID, String opis_kvara, Vozilo vozilo) {
        KvarID = kvarID;
        this.opis_kvara = opis_kvara;
        this.vozilo = vozilo;
    }

    public Integer getKvarID() {
        return KvarID;
    }

    public void setKvarID(Integer kvarID) {
        KvarID = kvarID;
    }

    public String getOpis_kvara() {
        return opis_kvara;
    }

    public void setOpis_kvara(String opis_kvara) {
        this.opis_kvara = opis_kvara;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }
}
