package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * 
 * @author ahofmann
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class SubstanceItem {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "substance_id")
    private Substance substance;

    @Basic
    private float amount;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
