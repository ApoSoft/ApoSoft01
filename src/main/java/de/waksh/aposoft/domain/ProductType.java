package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class ProductType {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;
}
