package de.wak_sh.aposoft.domain;

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

    // TODO: lhuebsch - Insurance befuellen sobald Datenmodell fertig

}
