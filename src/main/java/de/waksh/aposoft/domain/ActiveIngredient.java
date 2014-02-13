package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "extemporaneous_product_id")
    private ExtemporaneousProduct extemporaneousProduct;
}
