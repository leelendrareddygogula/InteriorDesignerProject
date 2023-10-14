package com.designs.interior.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.SuperAdmin;
import com.designs.interior.remote.SuperAdminRemote;
import com.designs.interior.repository.SuperAdminRepository;

@Service
public class SuperAdminData implements SuperAdminRemote
{
	
	@Autowired
	private SuperAdminRepository superAdminRepository;

	@Override
	public SuperAdmin getSuperAdminDetails(String uname, String pwd) 
	{
		return superAdminRepository.getSAdminDetails(uname, pwd);
	}
	
}
