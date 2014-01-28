package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
// Rezeptur
public class ExtemporaneousProduct {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String description;

    @Basic
    private String type;

    @ManyToOne
    @JoinColumn(name = "active_ingredient_id")
    private ActiveIngredient activeIngredient;

    @Basic
    private int amount;

    // Hier String, oder die Klasse Unit?
    @Basic
    private String unit;
}
