package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "quotationDetails")
public class Quotation 
{
	@Id
	@GeneratedValue(generator = "quotationIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "quotationIdGenerator", allocationSize = 1, initialValue = 1)
	private int componentId;
	@Column(unique = false, nullable = false, length = 100)
	private String name;
	@Column(unique = false, nullable = false, columnDefinition = "int default -1")
	private int height;
	@Column(unique = false, nullable = false, columnDefinition = "int default -1")
	private int width;
	@Column(unique = false, nullable = false)
	private int area;
	@Column(unique = false, nullable = false)
	private int quantity;
	@Column(unique = false, nullable = false)
	private int price;
	@Column(unique = false, nullable = false)
	private int total;
	@Column(unique = false, nullable = false)
	private int quotationId;
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}
	
}
