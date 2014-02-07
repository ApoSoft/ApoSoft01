package de.wak_sh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime birthdate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @ManyToOne
    @JoinColumn(name = "payment_condition_id")
    private PaymentCondition paymentCondition;

    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;

    @ManyToMany
    @JoinTable(joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "customer_group_id") })
    private CustomerGroup customerGroup;

}
