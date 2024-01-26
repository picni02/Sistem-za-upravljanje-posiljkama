package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TipID;

    @Column(nullable = false)
    @Size(max = 20)
    private String nazivTipa;

    @OneToMany(mappedBy = "tip", cascade = CascadeType.ALL)
    private List<Posiljka> posiljke;

    public Tip() {
    }

    public Tip(Integer tipID, String nazivTipa) {
        TipID = tipID;
        this.nazivTipa = nazivTipa;
    }

    public Tip(Integer tipID, String nazivTipa, List<Posiljka> posiljke) {
        TipID = tipID;
        this.nazivTipa = nazivTipa;
        this.posiljke = posiljke;
    }

    public Tip(Tip tip) {
        this.TipID = tip.getTipID();
        this.nazivTipa = tip.getNazivTipa();
        this.posiljke = tip.getPosiljke();
    }

    public Integer getTipID() {
        return TipID;
    }

    public void setTipID(Integer tipID) {
        TipID = tipID;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    public List<Posiljka> getPosiljke() {
        return posiljke;
    }

    public void setPosiljke(List<Posiljka> posiljke) {
        this.posiljke = posiljke;
    }
}
