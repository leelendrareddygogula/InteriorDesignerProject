package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.OnlineCustomer;
import com.designs.interior.remote.OnlineCustomerRemote;
import com.designs.interior.repository.OnlineCustomerRepository;

@Service
public class OnlineCustomerData implements OnlineCustomerRemote
{
	
	@Autowired
	private OnlineCustomerRepository onlineCustomerRepository;
	
	@Override
	public void addOnlineCustomer(OnlineCustomer customer) 
	{
		onlineCustomerRepository.save(customer);
	}

	@Override
	public void deleteOnlineCustomerById(int id) {
		onlineCustomerRepository.deleteById(id);
	}

	@Override
	public List<OnlineCustomer> getAllOnlineCustomersByStatus(boolean type) 
	{
		return onlineCustomerRepository.allRecordsWithStatus(type);
	}

	@Override
	public OnlineCustomer getById(int id) 
	{
		return onlineCustomerRepository.findById(id).get();
	}
	
}
