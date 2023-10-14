package com.designs.interior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Design;

@Repository
public interface DesignRepository extends CrudRepository<Design, Integer>
{
	@Query("select DISTINCT d.type from Design d")
	public List<String> getAllDistinctDesigns();
	
	@Query("select d from Design d where d.type=?1")
	public List<Design> getImageTypeDesigns(String type);
}
