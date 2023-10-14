package com.designs.interior.remote;

import com.designs.interior.entity.Designer;

public interface DesignerRemote 
{
	public Designer getDesignerDetails(String uname, String pwd);
	public Designer getByUsername(String uname);
	public String addNewDesigner(Designer designer);
}
