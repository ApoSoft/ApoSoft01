package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Domain fuer die Adresse
 * 
 * @author lhuebsch
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    // @ManyToOne(cascade = { CascadeType.ALL })
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Basic
    private String city;

    @Basic
    private String postalCode;

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
    private String phone;

    @Basic
    private String email;

}
