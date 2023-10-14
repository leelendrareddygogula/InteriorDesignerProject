package com.designs.interior.remote;

import com.designs.interior.entity.SuperAdmin;

public interface SuperAdminRemote 
{
	public SuperAdmin getSuperAdminDetails(String uname, String pwd);
}
