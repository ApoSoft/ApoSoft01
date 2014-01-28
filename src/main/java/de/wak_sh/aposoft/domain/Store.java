package de.wak_sh.aposoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "store")
    private MaterialsAdministration materialsAdministration;
}
