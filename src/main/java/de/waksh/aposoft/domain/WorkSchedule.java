package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.Duration;

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class WorkSchedule {
    @GeneratedValue
    @Id
    private int id;

    @OneToOne
    private Employee employee;

    @ManyToMany
    private List<Qualification> qualifications;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDurationAsString")
    private Duration actualHours;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDurationAsString")
    private Duration scheduledHours;

    @Basic
    private float accountBalance;

    @Basic
    private float days;
}
