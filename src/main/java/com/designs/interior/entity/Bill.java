package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "billDetails")
public class Bill 
{
	@Id
	@GeneratedValue(generator = "billIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "billIdGenerator", allocationSize = 1, initialValue = 1)
	private int billComponentId;
	@Column(nullable = false, unique = false, length = 150)
	private String componentName;
	@Column(unique = false, nullable = false)
	private int billId;
	@Column(unique = false, nullable = false)
	private int customerId;
	@Column(unique = false, nullable = false)
	private int quotationId;
	@Column(unique = false, nullable = false)
	private int amount;
	
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBillComponentId() {
		return billComponentId;
	}
	public void setBillComponentId(int billComponentId) {
		this.billComponentId = billComponentId;
	}
	@Override
	public String toString() {
		return "Bill [billComponentId=" + billComponentId + ", componentName=" + componentName + ", billId=" + billId
				+ ", customerId=" + customerId + ", quotationId=" + quotationId + ", amount=" + amount + "]";
	}
	
}
