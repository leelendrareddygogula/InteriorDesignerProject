package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.DesignType;
import com.designs.interior.remote.DesignTypeRemote;
import com.designs.interior.repository.DesignTypeRepository;

@Service
public class DesignTypeData implements DesignTypeRemote
{
	
	@Autowired
	private DesignTypeRepository designTypeRepository;
	
	@Override
	public String addNewImageComponent(DesignType designType)
	{
		String s = "";
		try
		{
			designTypeRepository.save(designType);
			s = "New Component Saved Successfully";
		}
		catch (DataIntegrityViolationException e) 
		{
			s = "Component already exists";
		}
		return s;
	}

	@Override
	public List<DesignType> getAllDesignTypes() 
	{
		return (List<DesignType>) designTypeRepository.findAll();
	}

	@Override
	public void deleteComponent(int id) 
	{
		designTypeRepository.deleteById(id);
	}
	
}
