package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer>
{
	@Query("select b from Bill b where b.billId = ?1")
	public List<Bill> getAllBillComponentsUsingBillId(int id);
}
