package de.wak_sh.aposoft.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ActiveIngredient {
	@Id
	@GeneratedValue
	private int id;

	@Basic
	private String name;
}
