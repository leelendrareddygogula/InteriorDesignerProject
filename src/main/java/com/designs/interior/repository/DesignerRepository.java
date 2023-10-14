package com.designs.interior.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.Designer;

@Repository
public interface DesignerRepository extends CrudRepository<Designer, String>
{
	@Query("select d from Designer d where username = ?1 and password = ?2")
	public Designer checkDesignerDetails(String un, String pwd);
	
}
