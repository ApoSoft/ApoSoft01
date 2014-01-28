package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MaterialsAdministration {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String store;

    @Basic
    private String location;

    @Basic
    private int amount;
}
