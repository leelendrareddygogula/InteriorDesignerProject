package com.designs.interior.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Customer;
import com.designs.interior.entity.Feedback;
import com.designs.interior.remote.FeedbackRemote;
import com.designs.interior.repository.FeedbackRepository;

@Service
public class FeedbackData implements FeedbackRemote
{
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public String addFeedback(Feedback feedback) {
		String s = "Thankyou for you valueable time, we appreciate your feedback! :-)";
		feedbackRepository.save(feedback);
		return s;
	}

	@Override
	public List<Customer> customersWithoutFeedback(List<Customer> customers) {
		List<Customer> returnList = new ArrayList<Customer>();
		for(Customer customer : customers)
		{
			int count = feedbackRepository.getTupleCount(customer.getId());
			if(count == 0)
			{
				returnList.add(customer);
			}
		}
		return returnList;
	}

	@Override
	public List<Feedback> allFeedbacks() 
	{
		return (List<Feedback>) feedbackRepository.findAll();
	}
	
}
