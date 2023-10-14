package com.designs.interior.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Imports;

@Repository
public interface ImportsRepository extends CrudRepository<Imports, String>
{
	
}
