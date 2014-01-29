package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String countryCode;

    @Basic
    private String name;

}
