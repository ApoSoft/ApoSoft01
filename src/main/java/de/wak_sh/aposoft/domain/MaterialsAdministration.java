package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class MaterialsAdministration {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "materialsAdministration")
    private Store store;

    @Basic
    private int amount;

    // TODO: relation missing
    // private Unit unit;
}
