package com.designs.interior.remote;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;

import com.designs.interior.entity.Design;

public interface DesignRemote 
{
	public String insertNewDesign(Design design) throws FileSizeLimitExceededException;
	public List<Design> getAllDesigns();
	public Design getDesignTuple(int id);
	public void deleteDesign(int id);
	public List<String> getDistinctDesigns();
	public List<Design> getImageTypeDesigns(String type);
}
