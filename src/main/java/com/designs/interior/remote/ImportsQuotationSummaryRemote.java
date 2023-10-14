package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.ImportsQuotationSummary;

public interface ImportsQuotationSummaryRemote 
{
	public int getMaxId();
	public String addImportsQuotationSummary(ImportsQuotationSummary summary);
	public List<ImportsQuotationSummary> getAllImportsQuotations();
	public ImportsQuotationSummary getById(int id);
}
