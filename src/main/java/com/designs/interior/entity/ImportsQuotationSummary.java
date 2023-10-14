package com.designs.interior.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "importsQuotationSummaryDetails")
public class ImportsQuotationSummary 
{
	@Id
	private int id;
	@Column(unique = false, nullable = false, length = 250)
	private String name;
	@Column(unique = false, nullable = false, length = 250)
	private String contactPerson;
	@Column(unique = false, nullable = false)
	private int calculatedAmount;
	@Column(unique = false, nullable = false)
	private int finalizedAmount;
	@Column(unique = false, nullable = false, length = 250)
	private long contactNumber;
	@Column(unique = false, nullable = false, length = 50)
	private String panOrGstin;
	@Column(unique = false, nullable = false)
	private Date date;
	@Column(unique = false, nullable = false, length = 250)
	private String address;
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
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public int getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(int calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	public int getFinalizedAmount() {
		return finalizedAmount;
	}
	public void setFinalizedAmount(int finalizedAmount) {
		this.finalizedAmount = finalizedAmount;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPanOrGstin() {
		return panOrGstin;
	}
	public void setPanOrGstin(String panOrGstin) {
		this.panOrGstin = panOrGstin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
