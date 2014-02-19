package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Entity class for employee qualifications
 * 
 * @author Christoph Mende
 * 
 */

@Data
@Entity
@SuppressWarnings("PMD.UnusedPrivateField")
public class Qualification {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private List<Employee> employees;
}
