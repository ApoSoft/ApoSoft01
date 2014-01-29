package de.wak_sh.aposoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "materials_administration_id")
    private MaterialsAdministration materialsAdministration;
}
