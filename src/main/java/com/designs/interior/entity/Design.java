package com.designs.interior.entity;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "interiorDesigns")
public class Design 
{
	@Id
	@GeneratedValue(generator = "interiorDesignsIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "interiorDesignsIdGenerator", initialValue = 1, allocationSize = 1)
	private int id;
	@Column(nullable = false, length = 200, unique = false)
	private String name;
	@Column(nullable = false, length = 200, unique = false)
	private Date dateUploaded;
	@Column(nullable = false, length = 200, unique = false)
	private String type;
	@Column(nullable = false, unique = false)
	private Blob image;
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
	public Date getDateUploaded() {
		return dateUploaded;
	}
	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	
}
