package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import org.joda.time.DateTime;

@Entity
@Data
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
    private DateTime birthdate;

    @Basic
    private float partTimePart;

}
