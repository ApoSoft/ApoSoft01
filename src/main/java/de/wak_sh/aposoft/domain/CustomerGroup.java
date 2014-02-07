/**
 * 
 */
package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Domain for CustomerGroup
 * 
 * @author lhuebsch
 * 
 */
@Entity
@Data
public class CustomerGroup {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @Basic
    private String description;

}
