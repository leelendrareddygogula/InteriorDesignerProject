package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.Imports;

public interface ImportsRemote 
{
	public String addImport(Imports imports);
	public String deleteImport(String id);
	public Imports getById(String id);
	public List<Imports> getAllImports();
}
