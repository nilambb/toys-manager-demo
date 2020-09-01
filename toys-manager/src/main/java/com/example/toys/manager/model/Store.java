package com.example.toys.manager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "store")
@Getter
@Setter
@ToString
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeID;
	private String storeName;
	private String city;
	private String address;
	private String pincode;
	private String description;

	@ManyToMany(targetEntity = Toy.class, fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "store_toys", joinColumns = @JoinColumn(name = "toyId"), inverseJoinColumns = @JoinColumn(name = "storeID"))
	private List<Toy> toys = new ArrayList<>();
}
