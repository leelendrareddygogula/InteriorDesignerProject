package com.designs.interior.data;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.ImportsQuotationSummary;
import com.designs.interior.remote.ImportsQuotationSummaryRemote;
import com.designs.interior.repository.ImportsQuotationSummaryRepository;

@Service
public class ImportsQuotationSummaryData implements ImportsQuotationSummaryRemote
{
	@Autowired
	private ImportsQuotationSummaryRepository importsQuotationSummaryRepository;
	
	@Override
	public int getMaxId() 
	{
		try
		{
			return importsQuotationSummaryRepository.getHigestID() + 1;
		}
		catch (AopInvocationException e) {
			return 1;
		}
	}

	@Override
	public String addImportsQuotationSummary(ImportsQuotationSummary summary) {
		importsQuotationSummaryRepository.save(summary);
		return "Quotation Generated Succesfully for Mr. " + summary.getName();
	}

	@Override
	public List<ImportsQuotationSummary> getAllImportsQuotations() 
	{	
		return (List<ImportsQuotationSummary>) importsQuotationSummaryRepository.findAll();
	}

	@Override
	public ImportsQuotationSummary getById(int id) 
	{
		ImportsQuotationSummary importsQuotationSummary = importsQuotationSummaryRepository.findById(id).get();
		return importsQuotationSummary;
	}
	
}
