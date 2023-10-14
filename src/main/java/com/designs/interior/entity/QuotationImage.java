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
@Table(name = "quotationImages")
public class QuotationImage 
{
	@Id
	@GeneratedValue(generator = "quotationImagesIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "quotationImagesIdGenerator")
	private int id;
	@Column(unique = false, nullable = false, length = 100)
	private String name;
	@Column(nullable = false, unique = false)
	private Blob image;
	@Column(nullable = false, unique = false)
	private Date uploadedDate;
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
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
	
}
