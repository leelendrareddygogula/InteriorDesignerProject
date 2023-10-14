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
@Table(name = "customerDetails")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerDetailsIdGenerator")
	@SequenceGenerator(name = "customerDetailsIdGenerator", allocationSize = 10, initialValue = 10)
	private int id;
	@Column(nullable = false, unique = false, length = 150)
	private String name;
	@Column(nullable = false, unique = false)
	private long contact;
	@Column(nullable = false, unique = false, length = 250)
	private String address;
	@Column(nullable = true, unique = false, length = 20)
	private String PANOrGSTIN;
	@Column(nullable = false, unique = true)
	private int quotationId;
	@Column(nullable = false, unique = false)
	private int calculatedTotal;
	@Column(nullable = false, unique = false)
	private int estimatedTotal;
	@Column(nullable = false, unique = false)
	private int remainingBalance;
	@Column(nullable = false, unique = false, length = 150)
	private String onBoardedBy;
	@Column(nullable = false, unique = false)
	private Date quotationDate;
	
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
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPANOrGSTIN() {
		return PANOrGSTIN;
	}
	public void setPANOrGSTIN(String pANOrGSTIN) {
		PANOrGSTIN = pANOrGSTIN;
	}
	public int getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}
	public int getEstimatedTotal() {
		return estimatedTotal;
	}
	public void setEstimatedTotal(int estimatedTotal) {
		this.estimatedTotal = estimatedTotal;
	}
	public int getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(int remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	public String getOnBoardedBy() {
		return onBoardedBy;
	}
	public void setOnBoardedBy(String onBoardedBy) {
		this.onBoardedBy = onBoardedBy;
	}
	public Date getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address
				+ ", PANOrGSTIN=" + PANOrGSTIN + ", quotationId=" + quotationId + ", estimatedTotal=" + estimatedTotal
				+ ", remainingBalance=" + remainingBalance + ", onBoardedBy=" + onBoardedBy + ", quotationDate="
				+ quotationDate + "]";
	}
	public int getCalculatedTotal() {
		return calculatedTotal;
	}
	public void setCalculatedTotal(int calculatedTotal) {
		this.calculatedTotal = calculatedTotal;
	}
	
}
