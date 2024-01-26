package com.example.ris.models.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Admin extends Radnik{
    public Admin() {
    }

    public Admin(Integer idRadnika, String firstName, String lastName, Date datum_rodjenja, String email, String password, String spol, String broj_telefona, String adresa, Date datum_zaposlenja, Integer roleId) {
        super(idRadnika, firstName, lastName, datum_rodjenja, email, password, spol, broj_telefona, adresa, datum_zaposlenja, roleId);
    }
}
