package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.BillSummary;

@Repository
public interface BillSummaryRepository extends CrudRepository<BillSummary, Integer>
{
	@Query("select max(billId) from BillSummary")
	public int getMaxBillSummaryId();
	
	@Query("select b from BillSummary b order by b.billId DESC")
	public List<BillSummary> getBillSummaryOrderedById();
}
