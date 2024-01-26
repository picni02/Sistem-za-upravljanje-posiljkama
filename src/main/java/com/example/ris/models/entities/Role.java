package com.example.ris.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleID;

    @Column(nullable = false)
    @Size(max = 20)
    private String nazivRole;

    public Role() {
    }

    public Role(Role role) {
        this.roleID = role.getRoleID();
        this.nazivRole = role.getNazivRole();
    }
    public Role(Integer roleID, String nazivRole) {
        this.roleID = roleID;
        this.nazivRole = nazivRole;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getNazivRole() {
        return nazivRole;
    }

    public void setNazivRole(String nazivRole) {
        this.nazivRole = nazivRole;
    }

}
