package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> 
{
	@Query("select c from Customer c ORDER BY c.quotationId DESC")
	public List<Customer> getAllSortedCustomers();
	
	@Query("select c from Customer c where c.quotationId = ?1")
	public Customer getCustomerDetailsWithQuotation(int qid);
	
	@Query("select max(quotationId) from Customer c")
	public int getMaxQuotationIdTillNow();
}
