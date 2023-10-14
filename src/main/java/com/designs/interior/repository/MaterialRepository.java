package com.designs.interior.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Material;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer>
{
	
}
