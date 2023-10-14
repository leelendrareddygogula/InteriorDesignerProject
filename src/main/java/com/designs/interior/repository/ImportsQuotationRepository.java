package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.ImportsQuotation;

@Repository
public interface ImportsQuotationRepository extends CrudRepository<ImportsQuotation, Integer>
{
	@Query("select i from ImportsQuotation i where i.id = ?1")
	public List<ImportsQuotation> getTuplesByQuotId(int id);
}
