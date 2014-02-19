package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * Entity class for logging
 * 
 * @author Christoph Mende
 * 
 */

@Data
@Entity
@SuppressWarnings("PMD.UnusedPrivateField")
public class Protocol {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User userId;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime time;

    @Basic
    private String description;

    @Basic
    private String comment;
}
