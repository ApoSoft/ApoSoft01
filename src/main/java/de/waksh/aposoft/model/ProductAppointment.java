/**
 * 
 */
package de.waksh.aposoft.model;

import lombok.Data;

import org.joda.time.LocalDate;

/**
 * @author lhuebsch
 * 
 */
@Data
public class ProductAppointment {

    private LocalDate date;
    private String product;
    private int amount;
    private String substances;

}
