package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Supplier {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @Basic
    private String shortdescription;

    @Basic
    private String contactPerson;

    @Basic
    private String website;

    @Basic
    private String rating;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "payment_condition_id")
    private PaymentCondition paymentCondition;

    @OneToOne
    @JoinColumn(name = "delivery_condition_id")
    private DeliveryCondition deliveryCondition;

}
