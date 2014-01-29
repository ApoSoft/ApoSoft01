package de.wak_sh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ProductShape {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "productShape")
    private List<Product> products;
}
