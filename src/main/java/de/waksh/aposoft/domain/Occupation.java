package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * Entity class for occupations
 * 
 * @author Christoph Mende
 * 
 */
@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class Occupation {
    @GeneratedValue
    @Id
    private int id;

    @Basic
    private String qualification;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate start;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate end;

    @ManyToOne
    private Branch branch;

    @OneToOne
    private Employee employee;
}
