package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Domain fuer die Versicherung
 * 
 * @author lhuebsch
 * 
 */
@Entity
@Data
public class Insurance {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String insuranceIdNumber;

    @Column(unique = true)
    private String name;

    @Basic
    private boolean privateInsurance;

    @Basic
    private String phone;

    // TODO: lhuebsch - Insurance befuellen sobald Datenmodell fertig

}
