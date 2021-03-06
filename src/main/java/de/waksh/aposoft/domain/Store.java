package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * Entity class for store (Lagerplatz)
 * 
 * @author Jannik Kuptz
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Store {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Branch branch;

    @Basic
    private int amount;

    @Basic
    private String depot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materials_administration_id")
    private MaterialsAdministration materialsAdministration;

    @OneToMany(mappedBy = "store")
    private List<Product> products;
}
