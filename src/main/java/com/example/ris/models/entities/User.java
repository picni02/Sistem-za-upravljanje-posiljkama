package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsera;

    @Size(max = 50)
    private String firstName;
    
    @Size(max = 50)
    private String lastName;

    @Size(max = 100)
    private String adresa;

    @Size(max = 255)
    @Column(unique = true)
    private String email;

    @Size(max = 255)
    private String password;

    @Column(nullable = false)
    private Integer roleId;

    // 0 - superadmin, 1 - administrator, 2 - dostavljač, 3 - korisnik

    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private List<Posiljka> posiljke;

    public User() {
    }

    public User(Integer idUsera, String firstName, String lastName, String adresa, String email, String password, Integer roleId, List<Posiljka> posiljke) {
        this.idUsera = idUsera;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresa = adresa;
        this.email = email;
        this.password = password;
        this.roleId = 3;
        this.posiljke = posiljke;
    }

    public User(User user) {
        this.idUsera = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.adresa = user.getAdresa();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roleId = user.getRoleId();
        this.posiljke = user.getPosiljke();
    }

    public Integer getId() {
        return this.idUsera;
    }

    public void setId(Integer id) {
        this.idUsera = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public Integer getIdUsera() {
        return idUsera;
    }

    public void setIdUsera(Integer idUsera) {
        this.idUsera = idUsera;
    }

    public List<Posiljka> getPosiljke() {
        return posiljke;
    }

    public void setPosiljke(List<Posiljka> posiljke) {
        this.posiljke = posiljke;
    }
}
