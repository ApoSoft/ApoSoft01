package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Vendor {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @Basic
    @Column(length = 3)
    private String vendorCode;

    @Basic
    private String website;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "vendor")
    private List<Product> products;
}
