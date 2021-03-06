package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Entity class for product shapes
 * 
 * @author Christoph Mende
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class ProductShape {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "productShape")
    private List<Product> products;
}
