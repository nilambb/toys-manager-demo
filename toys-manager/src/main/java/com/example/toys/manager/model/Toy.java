package com.example.toys.manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "toy")
@Getter
@Setter
@ToString
public class Toy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int toyId;
	private String toyName;
	private String category;
	private int idealAgeYearsLower;
	private int idealAgeYearsUpper;
	private String colour;
	
	//@ManyToMany(targetEntity = Store.class, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "toys")
	//private List<Store> stores;

}
