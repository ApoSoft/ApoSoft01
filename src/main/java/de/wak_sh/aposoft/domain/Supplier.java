package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    private Address address;

    private PaymentCondition paymentCondition;

    private DeliveryCondition deliveryCondion;

}
