package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "importsQuotationDetails")
public class ImportsQuotation 
{
	@Id
	@GeneratedValue(generator = "importsQuotationIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "importsQuotationIdGenerator")
	private int componentid;
	@Column(nullable = false, unique = false, length = 100)
	private String importreference;
	@Column(nullable = false, unique = false, length = 100)
	private String name;
	@Column(nullable = false, unique = false)
	private int quantity;
	@Column(nullable = false, unique = false)
	private int id;
	@Column(nullable = false, unique = false)
	private int price;
	@Column(nullable = false, unique = false)
	private int amount;
	public String getImportreference() {
		return importreference;
	}
	public void setImportreference(String importreference) {
		this.importreference = importreference;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getComponentid() {
		return componentid;
	}
	public void setComponentid(int componentid) {
		this.componentid = componentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
