package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DesignTypeDetails")
public class DesignType 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "designTypeIdGenerator")
	@SequenceGenerator(name = "designTypeIdGenerator" ,allocationSize = 1, initialValue = 100)
	private int id;
	@Column(unique = true, nullable = false, length = 100)
	private String name;
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
	
	
}
