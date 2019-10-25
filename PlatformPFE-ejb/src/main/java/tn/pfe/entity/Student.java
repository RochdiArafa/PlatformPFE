package tn.pfe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends User implements Serializable{

	@ManyToOne
	private Company company;
}
