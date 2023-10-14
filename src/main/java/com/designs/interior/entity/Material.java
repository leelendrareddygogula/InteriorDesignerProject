package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "materialDetails")
public class Material 
{
	@Id
	@GeneratedValue(generator = "materialIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "materialIdGenerator", allocationSize = 1, initialValue = 100)
	private int id;
	@Column(nullable = false, unique = true, length = 150)
	private String name;
	@Column(nullable = false, unique = false)
	private int price;
	@Column(nullable = false, unique = false)
	private boolean variesWithMeasurements;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isVariesWithMeasurements() {
		return variesWithMeasurements;
	}
	public void setVariesWithMeasurements(boolean variesWithMeasurements) {
		this.variesWithMeasurements = variesWithMeasurements;
	}
	
	
}
