/**
 * 
 */
package de.wak_sh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Domain for CustomerGroup
 * 
 * @author lhuebsch
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class CustomerGroup {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @Basic
    private String description;

    @ManyToMany(mappedBy = "customerGroups")
    private List<Customer> customers;
}
