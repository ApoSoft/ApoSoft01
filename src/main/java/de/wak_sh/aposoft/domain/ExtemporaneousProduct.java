package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entity class for extemporaneous products
 * 
 * @author Jannik Kuptz
 * 
 */
@Entity
@Data
// Rezeptur
public class ExtemporaneousProduct {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String description;

    // TODO manifacturer relation
}
