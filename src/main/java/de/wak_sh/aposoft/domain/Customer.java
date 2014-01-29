package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String title;

    @Basic
    private String name;

    @Basic
    private String firstName;

    @Basic
    private String gender;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private DateTime birthdate;

    @Basic
    private Address address;

    private Insurance insurance;

    private PaymentCondition paymentCondition;

}
