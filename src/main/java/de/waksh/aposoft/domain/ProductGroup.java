package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author ahofmann
 * 
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@SuppressWarnings("PMD.UnusedPrivateField")
public class ProductGroup {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    @NonNull
    private String name;

    @Basic
    @NonNull
    private String description;

    @OneToMany(mappedBy = "productGroup")
    private List<Product> products;
}
