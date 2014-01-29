package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Country country;

    @Basic
    private String city;

    @Basic
    private int postalCode;

    @Basic
    private String street;

    @Basic
    private String number;

    @Basic
    private String extra01;

    @Basic
    private String extra02;

    @Basic
    private String extra03;

    @Basic
    private int phone;

    @Basic
    private String email;

}
