package de.wak_sh.aposoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DeliveryCondition {

    @Id
    @GeneratedValue
    private int id;

    // TODO: lhuebsch - befuelle DeliveryCondition mit Inhalt sobald Datenmodell
    // fertig

}
