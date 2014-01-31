package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author ahofmann
 * 
 */

@Entity
@Data
public class Substance {

    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;
}
