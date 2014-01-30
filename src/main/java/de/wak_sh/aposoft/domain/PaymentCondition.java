package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Data
public class PaymentCondition {

    @Id
    @GeneratedValue
    private int id;

    // Zahlungsziel
    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime paymentDate;

    // Skontofrist
    @Basic
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime discountDate;

    @Basic
    private float discountValue;

}
