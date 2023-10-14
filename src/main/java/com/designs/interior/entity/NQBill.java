package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "nonQuotationBillDetails")
public class NQBill 
{
	@Id
	@GeneratedValue(generator = "nonQuotationBillIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "nonQuotationBillIdGenerator", allocationSize = 1, initialValue = 1)
	private int cid;
	@Column(nullable = false, unique = false, length = 150)
	private String name;
	@Column(nullable = false, unique = false)
	private int amount;
	@Column(nullable = false, unique = false)
	private int nbid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getNbid() {
		return nbid;
	}
	public void setNbid(int nbid) {
		this.nbid = nbid;
	}
	
	
}
