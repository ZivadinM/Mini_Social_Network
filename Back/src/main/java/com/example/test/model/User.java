package com.example.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {

    @Id
    private int jmbg;

    private String firstname;
    private String lastname;
    private int years;
    private String picture;

    public User(int jmbg, String firstname,String lastname, int years,String picture) {
        super();
        this.jmbg = jmbg;
        this.firstname=firstname;
        this.lastname = lastname;
        this.years = years;
        this.picture = picture;
    }

    public User() {
        super();
    }

    public int getJmbg() {
        return jmbg;
    }

    public void setJmbg(int jmbg) {
        this.jmbg = jmbg;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean compare(String lastname,String firstname, int years) {
        return Objects.equals(firstname, this.getFirstname()) &&
                Objects.equals(lastname, this.getLastname()) &&
                Objects.equals(years, this.getYears()
                );
    }
}
