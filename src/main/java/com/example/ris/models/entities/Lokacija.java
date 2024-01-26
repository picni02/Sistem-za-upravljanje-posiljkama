package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Lokacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LokacijaID;

    @Column(nullable = false, unique = true)
    @Size(max = 10)
    private Integer postanski_broj;

    @Column(nullable = false)
    @Size(max = 50)
    private String nazivLokacije;

    @OneToMany(mappedBy = "lokacija", cascade = CascadeType.ALL)
    private List<Okrug> okruzi;

    public Lokacija() {
    }

    public Lokacija(Integer lokacijaID, Integer postanski_broj, String nazivLokacije) {
        LokacijaID = lokacijaID;
        this.postanski_broj = postanski_broj;
        this.nazivLokacije = nazivLokacije;
    }

    public Lokacija(Integer lokacijaID, Integer postanski_broj, String nazivLokacije, List<Okrug> okruzi) {
        LokacijaID = lokacijaID;
        this.postanski_broj = postanski_broj;
        this.nazivLokacije = nazivLokacije;
        this.okruzi = okruzi;
    }

    public Lokacija(Lokacija lokacija) {
        this.LokacijaID = lokacija.getLokacijaID();
        this.nazivLokacije = lokacija.getNazivLokacije();
        this.postanski_broj = lokacija.getPostanski_broj();
        this.okruzi = lokacija.getOkruzi();
    }

    public Integer getLokacijaID() {
        return LokacijaID;
    }

    public void setLokacijaID(Integer lokacijaID) {
        LokacijaID = lokacijaID;
    }

    public Integer getPostanski_broj() {
        return postanski_broj;
    }

    public void setPostanski_broj(Integer postanski_broj) {
        this.postanski_broj = postanski_broj;
    }

    public String getNazivLokacije() {
        return nazivLokacije;
    }

    public void setNazivLokacije(String nazivLokacije) {
        this.nazivLokacije = nazivLokacije;
    }

    public List<Okrug> getOkruzi() {
        return okruzi;
    }

    public void setOkruzi(List<Okrug> okruzi) {
        this.okruzi = okruzi;
    }
}
