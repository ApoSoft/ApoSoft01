package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Domain fuer das Land
 * 
 * @author lhuebsch
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Country {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String countryCode;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Address> addresses;

}
