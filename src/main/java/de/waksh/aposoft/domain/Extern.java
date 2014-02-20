package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Entity class for external employees
 * 
 * @author Christoph Mende
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Extern {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @ManyToOne(cascade = { CascadeType.ALL })
    private Address address;

    @Basic
    private String description;

}
