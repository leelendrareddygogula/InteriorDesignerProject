package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.DesignType;

public interface DesignTypeRemote 
{
	public String addNewImageComponent(DesignType designType);
	public List<DesignType> getAllDesignTypes();
	public void deleteComponent(int id);
}
