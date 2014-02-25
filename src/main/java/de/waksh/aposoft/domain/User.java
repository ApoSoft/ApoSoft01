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
import org.joda.time.LocalDate;

/**
 * Entity class for system users that are associated to employees
 * 
 * @author Christoph Mende
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Basic
    private String username;

    @Basic
    private String password;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<Role> roles;

    @ManyToOne(cascade = CascadeType.ALL)
    private Branch branch;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipe;
}
