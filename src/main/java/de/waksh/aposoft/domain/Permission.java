package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Entity class for role permissions
 * 
 * @author Christoph Mende
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Permission {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;
}
