package com.designs.interior.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.designs.interior.entity.SuperAdmin;

@Repository
public interface SuperAdminRepository extends CrudRepository<SuperAdmin, String>
{
	@Query("select s from SuperAdmin s where s.username = ?1 and s.password = ?2")
	public SuperAdmin getSAdminDetails(String uname, String pwd);
}
