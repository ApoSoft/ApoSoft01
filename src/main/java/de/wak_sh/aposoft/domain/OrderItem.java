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
public class OrderItem {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Basic
    private int amount;
}
