package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.OnlineCustomer;

@Repository
public interface OnlineCustomerRepository extends CrudRepository<OnlineCustomer, Integer>
{
	@Query("select o from OnlineCustomer o where o.contacted = ?1")
	public List<OnlineCustomer> allRecordsWithStatus(boolean bool);
}
