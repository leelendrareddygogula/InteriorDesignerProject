package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.NQBillSummary;

@Repository
public interface NQBillSummaryRepository extends CrudRepository<NQBillSummary, Integer>
{
	@Query("select max(id) from NQBillSummary n")
	public int getMaxIdOfNQBillSummary();
	
	@Query("select n from NQBillSummary n order by n.id DESC")
	public List<NQBillSummary> allNQBillSummary();
}
