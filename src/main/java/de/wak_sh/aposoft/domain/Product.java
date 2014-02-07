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
@SuppressWarnings("PMD.UnusedPrivateField")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Basic
    private boolean prescription;

    @Basic
    private float dosage;

    @Basic
    private int width;

    @Basic
    private int height;

    @Basic
    private int length;

    @Basic
    private float price;

    @ManyToOne
    @JoinColumn(name = "product_shape_id")
    private ProductShape productShape;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
