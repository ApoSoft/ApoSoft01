package de.wak_sh.aposoft.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * 
 * @author ahofmann
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    @JoinTable(joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = { @JoinColumn(name = "substance_item_id") })
    private List<SubstanceItem> items;
}
