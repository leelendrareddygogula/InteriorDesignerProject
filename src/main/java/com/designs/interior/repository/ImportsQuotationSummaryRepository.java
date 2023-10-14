package com.designs.interior.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.ImportsQuotationSummary;

@Repository
public interface ImportsQuotationSummaryRepository extends CrudRepository<ImportsQuotationSummary, Integer>
{
	@Query("select max(id) from ImportsQuotationSummary i")
	public int getHigestID();
}
