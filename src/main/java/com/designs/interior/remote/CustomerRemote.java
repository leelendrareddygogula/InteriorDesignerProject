package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.Customer;

public interface CustomerRemote 
{
	public String addNewCustomer(Customer customer);
	public List<Customer> allCustomersSorted();
	public Customer getCustomerDetailsOnQuotationId(int id);
	public Customer getCustomerDetailsOnCustomerId(int id);
	public int maxQuotationIdTillNow();
}
