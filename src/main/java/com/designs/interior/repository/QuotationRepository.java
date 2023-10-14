package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Quotation;

@Repository
public interface QuotationRepository extends CrudRepository<Quotation, Integer>
{
	@Query("select max(q.quotationId) from Quotation q")
	public int maxQuotationAvailable();
	
	@Query("select q from Quotation q where q.quotationId = ?1")
	public List<Quotation> allQuotationComponentsBasedOnId(int id);
}
