package com.designs.interior.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedbackDetails")
public class Feedback 
{
	@Id
	private int customerId;
	@Column(nullable = false, unique = false)
	private int quality;
	@Column(nullable = false, unique = false)
	private int colourPrecesion;
	@Column(nullable = false, unique = false)
	private int designRating;
	@Column(nullable = false, unique = false)
	private int changesRating;
	@Column(nullable = false, unique = false)
	private String timeLine;
	@Column(nullable = false, unique = false)
	private int communication;
	@Column(columnDefinition = "text")
	private String comments;
	@Column(nullable = false, unique = true)
	private String customerDetails;
	@Column(nullable = false, unique = false)
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getColourPrecesion() {
		return colourPrecesion;
	}
	public void setColourPrecesion(int colourPrecesion) {
		this.colourPrecesion = colourPrecesion;
	}
	public int getDesignRating() {
		return designRating;
	}
	public void setDesignRating(int designRating) {
		this.designRating = designRating;
	}
	public int getChangesRating() {
		return changesRating;
	}
	public void setChangesRating(int changesRating) {
		this.changesRating = changesRating;
	}
	public String getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}
	public int getCommunication() {
		return communication;
	}
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}
	
	
}
