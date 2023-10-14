package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.Customer;
import com.designs.interior.entity.Feedback;

public interface FeedbackRemote 
{
	public String addFeedback(Feedback feedback);
	public List<Customer> customersWithoutFeedback(List<Customer> customers);
	public List<Feedback> allFeedbacks();
}
