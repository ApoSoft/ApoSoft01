package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.Duration;

@Entity
@Data
public class WorkSchedule {
    @GeneratedValue
    @Id
    private int id;

    @OneToOne
    private Employee employee;

    @Basic
    private String qualification;

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
