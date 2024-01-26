package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Radnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRadnika;

    @Column(nullable = false)
    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date datum_rodjenja;

    @Size(max = 255)
    @Column(unique = true, nullable = false)
    private String email;

    @Size(max = 255)
    @Column(nullable = false)
    private String password;

    @Size(max = 10)
    @Column(nullable = false)
    private String spol;

    @Size(max = 20)
    @Column(nullable = false)
    private String broj_telefona;

    @Size(max = 100)
    @Column(nullable = false)
    private String adresa;

    @Column(nullable = false)
    private Date datum_zaposlenja;

    @Column(nullable = false)
    private Integer roleId;
    // 0 - superadmin, 1 - admin, 2 - dostavljač


    public Radnik() {
    }

    public Radnik(Integer idRadnika, String firstName, String lastName, Date datum_rodjenja, String email, String password, String spol, String broj_telefona, String adresa, Date datum_zaposlenja, Integer roleId) {
        this.idRadnika = idRadnika;
        this.firstName = firstName;
        this.lastName = lastName;
        this.datum_rodjenja = datum_rodjenja;
        this.email = email;
        this.password = password;
        this.spol = spol;
        this.broj_telefona = broj_telefona;
        this.adresa = adresa;
        this.datum_zaposlenja = datum_zaposlenja;
        this.roleId = 2;
    }

    public Radnik(Radnik radnik) {
        this.idRadnika = radnik.getIdRadnika();
        this.firstName = radnik.getFirstName();
        this.lastName = radnik.getLastName();
        this.datum_rodjenja = radnik.getDatum_rodjenja();
        this.email = radnik.getEmail();
        this.password = radnik.getPassword();
        this.spol = radnik.getSpol();
        this.broj_telefona = radnik.getBroj_telefona();
        this.adresa = radnik.getAdresa();
        this.datum_zaposlenja = radnik.getDatum_zaposlenja();
        this.roleId = radnik.getRoleId();
    }

    public Integer getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(Integer idRadnika) {
        this.idRadnika = idRadnika;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getBroj_telefona() {
        return broj_telefona;
    }

    public void setBroj_telefona(String broj_telefona) {
        this.broj_telefona = broj_telefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatum_zaposlenja() {
        return datum_zaposlenja;
    }

    public void setDatum_zaposlenja(Date datum_zaposlenja) {
        this.datum_zaposlenja = datum_zaposlenja;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
