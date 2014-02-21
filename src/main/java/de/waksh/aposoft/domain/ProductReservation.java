package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * 
 * @author ahofmann
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class ProductReservation {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = { CascadeType.ALL })
    private List<ProductReservationItem> items;
}
