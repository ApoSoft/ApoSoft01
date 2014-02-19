package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 * 
 * @author ahofmann
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
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

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "payment_condition_id")
    private PaymentCondition paymentCondition;

    @OneToMany(mappedBy = "customer", cascade = { CascadeType.ALL })
    private List<AppointmentCustomer> appointments;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "customer_group_id") })
    private List<CustomerGroup> customerGroups;

}
