package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * Entity class for logging
 * 
 * @author Christoph Mende
 * 
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@SuppressWarnings("PMD.UnusedPrivateField")
public class Protocol {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @NonNull
    private User user;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime time;

    @Basic
    @NonNull
    private String description;

    @Basic
    @NonNull
    private String comment;

    @PrePersist
    public void prePersist() {
        time = new LocalDateTime();
    }
}
