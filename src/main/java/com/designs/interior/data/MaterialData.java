package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Material;
import com.designs.interior.remote.MaterialRemote;
import com.designs.interior.repository.MaterialRepository;

@Service
public class MaterialData implements MaterialRemote
{
	
	@Autowired
	private MaterialRepository materialRepository;

	@Override
	public String addMaterial(Material material) 
	{
		materialRepository.save(material);
		return "Component Saved Successfully";
	}

	@Override
	public List<Material> getAllMaterials() 
	{
		List<Material> materials = (List<Material>) materialRepository.findAll();
		return materials;
	}

	@Override
	public void deleteMaterial(int id) 
	{
		materialRepository.deleteById(id);
	}

	@Override
	public Material findById(int id) 
	{
		Material material = materialRepository.findById(id).get();
		return material;
	}
}
