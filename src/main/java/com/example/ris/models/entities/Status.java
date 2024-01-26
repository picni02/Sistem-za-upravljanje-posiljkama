package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StatusID;

    @Column(nullable = false)
    @Size(max = 20)
    private String nazivStatusa;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Posiljka> posiljke;

    public Status() {
    }

    public Status(Integer statusID, String nazivStatusa, List<Posiljka> posiljke) {
        StatusID = statusID;
        this.nazivStatusa = nazivStatusa;
        this.posiljke = posiljke;
    }

    public Status(Integer statusID, String nazivStatusa) {
        StatusID = statusID;
        this.nazivStatusa = nazivStatusa;
    }

    public Status(Status status) {
        this.nazivStatusa = status.getNazivStatusa();
        this.posiljke = status.posiljke;
        this.StatusID = status.getStatusID();
    }

    public Integer getStatusID() {
        return StatusID;
    }

    public void setStatusID(Integer statusID) {
        StatusID = statusID;
    }

    public String getNazivStatusa() {
        return nazivStatusa;
    }

    public void setNazivStatusa(String nazivStatusa) {
        this.nazivStatusa = nazivStatusa;
    }

    public List<Posiljka> getPosiljke() {
        return posiljke;
    }

    public void setPosiljke(List<Posiljka> posiljke) {
        this.posiljke = posiljke;
    }
}
