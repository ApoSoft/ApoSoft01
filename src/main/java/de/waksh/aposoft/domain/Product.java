package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * 
 * @author ahofmann
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne(cascade = { CascadeType.ALL })
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

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate bestBeforeDate;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "product_shape_id")
    private ProductShape productShape;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id")
    private Store store;

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", vendor=" + vendor.getName() + "]";
    }

}
