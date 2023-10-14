package com.designs.interior.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "onlineCustomerDetails")
public class OnlineCustomer 
{
	@Id
	@GeneratedValue(generator = "onlineCustomerIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "onlineCustomerIdGenerator", initialValue = 1000, allocationSize = 100)
	private int id;
	@Column(nullable = false, unique = false, length = 150)
	private String name;
	@Column(nullable = false, unique = false, length = 150)
	private String language;
	@Column(nullable = false, unique = false)
	private long mobile;
	@Column(nullable = false, unique = false)
	private Date dateQuotatedOn;
	@Column(nullable = false, unique = false)
	private boolean contacted;
	
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Date getDateQuotatedOn() {
		return dateQuotatedOn;
	}
	public void setDateQuotatedOn(Date dateQuotatedOn) {
		this.dateQuotatedOn = dateQuotatedOn;
	}
	public boolean isContacted() {
		return contacted;
	}
	public void setContacted(boolean contacted) {
		this.contacted = contacted;
	}
	
}
