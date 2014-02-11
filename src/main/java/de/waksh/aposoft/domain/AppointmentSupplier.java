/**
 * 
 */
package de.waksh.aposoft.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * Domain for supplier-appointments
 * 
 * @author lhuebsch
 * 
 */

@Entity
@Data
@SuppressWarnings("PMD.UnusedPrivateField")
public class AppointmentSupplier {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate date;

    @ManyToMany
    @JoinTable(joinColumns = { @JoinColumn(name = "appointment_id") }, inverseJoinColumns = { @JoinColumn(name = "order_item_id") })
    private List<OrderItem> items;

}
