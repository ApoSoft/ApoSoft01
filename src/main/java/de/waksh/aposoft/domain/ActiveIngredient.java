package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Entity class for active ingredients (Wirkstoff)
 * 
 * @author ahofmann
 * 
 */

@Data
@Entity
@SuppressWarnings("PMD.UnusedPrivateField")
public class ActiveIngredient {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "activeIngredients", fetch = FetchType.EAGER)
    private List<Recipe> recipes;
}
