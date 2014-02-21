/**
 * 
 */
package de.waksh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * Item for product reservations in the customer panel
 * 
 * @author lhuebsch
 * 
 */

@Entity
@Data
public class ProductReservationItem {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private int amount;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Basic
    private boolean available;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate reservedUntil;

}
