package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.Material;

public interface MaterialRemote 
{
	public String addMaterial(Material material);
	public List<Material> getAllMaterials();
	public void deleteMaterial(int id);
	public Material findById(int id);
}
