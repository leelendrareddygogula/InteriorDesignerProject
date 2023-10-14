package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.NQBill;

@Repository
public interface NQBillRepository extends CrudRepository<NQBill, Integer>
{
	@Query("select nq from NQBill nq where nq.nbid = ?1")
	public List<NQBill> getAllBillsBasedOnId(int id);
}
