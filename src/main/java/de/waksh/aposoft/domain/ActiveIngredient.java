package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
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
}
