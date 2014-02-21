package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "recipe")
    private List<ActiveIngredient> activeIngredient;

    @OneToMany(mappedBy = "recipe")
    private List<Product> products;
}
