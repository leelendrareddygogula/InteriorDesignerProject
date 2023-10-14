package com.designs.interior.data;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Imports;
import com.designs.interior.remote.ImportsRemote;
import com.designs.interior.repository.ImportsRepository;

@Service
public class ImportsData implements ImportsRemote
{
	@Autowired
	private ImportsRepository importsRepository;

	@Override
	public String addImport(Imports imports) {
		String s;
		try 
		{
			importsRepository.save(imports);
			s = "Saved Successfully";
		}
		catch (Exception e) 
		{
			s = e.toString();
		}
		return s;
	}

	@Override
	public String deleteImport(String id) 
	{
		try
		{
			importsRepository.deleteById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "Deleted Successfully";
	}

	@Override
	public Imports getById(String id) 
	{
		Imports imports;
		try
		{
			imports = importsRepository.findById(id).get();
		}
		catch (NoSuchElementException e) {
			imports = null;
		}
		return imports;
	}

	@Override
	public List<Imports> getAllImports() 
	{
		return (List<Imports>) importsRepository.findAll();
	}
	
}
