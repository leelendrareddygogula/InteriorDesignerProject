package com.designs.interior.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nonQuotationBillSummaryDetails")
public class NQBillSummary 
{
	@Id
	private int id;
	@Column(nullable = false, unique = false, length = 150)
	private String customerName;
	@Column(nullable = false, unique = false)
	private Date billDate;
	@Column(nullable = false, unique = false)
	private int price;
	@Column(nullable = false, unique = false)
	private int gst;
	@Column(nullable = false, unique = false)
	private int amount;
	@Column(nullable = false, unique = false)
	private long mobileNumber;
	@Column(nullable = true, unique = false, length = 150)
	private String refferedBy;
	@Column(nullable = true, unique = false, length = 25)
	private String panOrGstin;
	@Column(nullable = false, unique = false, length = 30)
	private String billingMethod;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRefferedBy() {
		return refferedBy;
	}
	public void setRefferedBy(String refferedBy) {
		this.refferedBy = refferedBy;
	}
	public String getPanOrGstin() {
		return panOrGstin;
	}
	public void setPanOrGstin(String panOrGstin) {
		this.panOrGstin = panOrGstin;
	}
	public String getBillingMethod() {
		return billingMethod;
	}
	public void setBillingMethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}
	
}
