package com.designs.interior.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "importsDetails")
public class Imports 
{
	@Id
	@Column(length = 50)
	private String id;
	@Column(unique = false, nullable = false)
	private String name;
	@Column(unique = false, nullable = false)
	private Blob image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	
}
