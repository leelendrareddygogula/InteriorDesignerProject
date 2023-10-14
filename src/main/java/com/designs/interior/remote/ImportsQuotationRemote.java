package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.ImportsQuotation;

public interface ImportsQuotationRemote 
{
	public void addImportsQuotation(ImportsQuotation importsQuotation);
	public void deleteImportsQuotationById(int cid);
	public List<ImportsQuotation> getListbyId(int id);
	public ImportsQuotation getDetailsById(int id);
}
