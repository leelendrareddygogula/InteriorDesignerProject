package com.designs.interior.data;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Customer;
import com.designs.interior.remote.CustomerRemote;
import com.designs.interior.repository.CustomerRepository;

@Service
public class CustomerData implements CustomerRemote
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String addNewCustomer(Customer customer) 
	{
		String s = "";
		try
		{
			customerRepository.save(customer);
			s = "Quotation generated successfully with customer name " + customer.getName() + " and quotation id " + customer.getQuotationId();
		}
		catch (DataIntegrityViolationException e) 
		{
			System.out.println(e);
			s = "Customer details already exists";
		}
		return s;
	}

	@Override
	public List<Customer> allCustomersSorted() 
	{
		return customerRepository.getAllSortedCustomers();
	}

	@Override
	public Customer getCustomerDetailsOnQuotationId(int id) 
	{
		return customerRepository.getCustomerDetailsWithQuotation(id);
	}

	@Override
	public Customer getCustomerDetailsOnCustomerId(int id) 
	{
		return customerRepository.findById(id).get();
	}

	@Override
	public int maxQuotationIdTillNow() 
	{
		int id;
		try
		{
			id = customerRepository.getMaxQuotationIdTillNow();
			id += 1;
		}
		catch (AopInvocationException e) 
		{
			id = 1;
		}
		return id;
	}
	
	
}
