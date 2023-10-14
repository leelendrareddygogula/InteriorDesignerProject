package com.designs.interior.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.DesignType;

@Repository
public interface DesignTypeRepository extends CrudRepository<DesignType, Integer>
{
	
}
