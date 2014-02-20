/**
 * 
 */
package de.waksh.aposoft.model;

import lombok.Data;

import org.joda.time.LocalDate;

/**
 * Item for product reservations in the customer panel
 * 
 * @author lhuebsch
 * 
 */
@Data
public class ProductReservationItem {

    private String product;
    private int amount;
    private String branch;
    private Boolean available;
    private LocalDate reservedUntil;

}
