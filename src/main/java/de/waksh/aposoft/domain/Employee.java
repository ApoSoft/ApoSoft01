package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * Entity class for employees
 * 
 * @author Christoph Mende
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Employee {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @Basic
    private String firstName;

    @Basic
    private String title;

    @Basic
    private String gender;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthdate;

    @Basic
    private float partTimePart;

    @OneToMany(mappedBy = "employee")
    private List<User> users;
}
