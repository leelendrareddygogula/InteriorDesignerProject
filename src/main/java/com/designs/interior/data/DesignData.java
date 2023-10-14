package com.designs.interior.data;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.designs.interior.entity.Design;
import com.designs.interior.remote.DesignRemote;
import com.designs.interior.repository.DesignRepository;

@Service
public class DesignData implements DesignRemote
{

	@Autowired
	private DesignRepository designRepository;
	
	@Override
	public String insertNewDesign(Design design) throws FileSizeLimitExceededException
	{
		String s = "";
		try
		{
			designRepository.save(design);
			s =  "File Saved Successfully";
		}
		catch (MaxUploadSizeExceededException e) 
		{
			s = "Max Size Limit Exceeded, allowed only 1MB";
		}
		catch (IllegalStateException e) {
			s = "Max Size Limit Exceeded, allowed only 1MB";
		}
		return s;
	}
	
	
	public List<Design> getAllDesigns() 
	{
		return (List<Design>) designRepository.findAll();
	}


	@Override
	public Design getDesignTuple(int id) 
	{
		Design design = designRepository.findById(id).get();
		return design;
	}


	@Override
	public void deleteDesign(int id) 
	{
		designRepository.deleteById(id);
	}


	@Override
	public List<String> getDistinctDesigns() 
	{
		return designRepository.getAllDistinctDesigns();
	}


	@Override
	public List<Design> getImageTypeDesigns(String type) 
	{
		return designRepository.getImageTypeDesigns(type);
	}
}
