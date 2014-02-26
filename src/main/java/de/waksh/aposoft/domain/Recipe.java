package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Entity class for recipes (Rezeptur)
 * 
 * @author Jannik Kuptz
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Recipe {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String description;

    @Basic
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = { @JoinColumn(name = "active_ingredient_id") })
    private List<ActiveIngredient> activeIngredients;

    @OneToMany(mappedBy = "recipe")
    private List<Product> products;
}
