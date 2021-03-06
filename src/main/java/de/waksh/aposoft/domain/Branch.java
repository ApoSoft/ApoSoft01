package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Entity class for branch offices (Filiale)
 * 
 * @author Christoph Mende
 * 
 */
@Data
@Entity
@SuppressWarnings("PMD.UnusedPrivateField")
public class Branch {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String description;

    @Basic
    private String address;

    @Basic
    private String location;

    @Basic
    private String manager;

    @Basic
    private String logo;

    @OneToMany(mappedBy = "branch")
    private List<Occupation> occupations;

    @OneToMany(mappedBy = "branch")
    private List<User> users;
}
