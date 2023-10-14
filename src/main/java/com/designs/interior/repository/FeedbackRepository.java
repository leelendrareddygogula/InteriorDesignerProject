package com.designs.interior.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>
{
	@Query("select count(*) from Feedback f where customerId=?1")
	public int getTupleCount(int id);
}
