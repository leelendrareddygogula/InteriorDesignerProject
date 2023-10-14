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
@Table(name = "billSummaryDetails")
public class BillSummary 
{
	@Id
//	@GeneratedValue(generator = "billSummaryIdGenerator", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "billSummaryIdGenerator", allocationSize = 100, initialValue = 10000)
	private int billId;
	@Column(nullable = false, unique = false)
	private int totalAmount;
	@Column(nullable = false, unique = false)
	private int customerId;
	@Column(nullable = false, unique = false, length = 150)
	private String customerName;
	@Column(nullable = false, unique = false)
	private int quotationId;
	@Column(nullable = false, unique = false)
	private Date billDate;
	@Column(nullable = false, unique = false)
	private int gstPercentage;
	@Column(nullable = false, unique = false)
	private int totalPrice;
	@Column(nullable = false, unique = false, length = 30)
	private String billingMethod;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public int getGstPercentage() {
		return gstPercentage;
	}
	public void setGstPercentage(int gstPercentage) {
		this.gstPercentage = gstPercentage;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getBillingMethod() {
		return billingMethod;
	}
	public void setBillingMethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}
	
	
}
