package com.designs.interior.data;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Quotation;
import com.designs.interior.remote.QuotationRemote;
import com.designs.interior.repository.QuotationRepository;

@Service
public class QuotationData implements QuotationRemote
{
	@Autowired
	private QuotationRepository quotationRepository;
	
	@Override
	public void addAQuotationComponent(Quotation quotation) 
	{
		quotationRepository.save(quotation);
	}

	@Override
	public int maxQuotationIdTillNow() 
	{
		int id;
		try
		{
			id = quotationRepository.maxQuotationAvailable();
			id += 1;
		}
		catch (AopInvocationException e) 
		{
			id = 1;
		}
		return id;
	}

	@Override
	public List<Quotation> getCustomerQuotationBasedOnQId(int id) 
	{
		return quotationRepository.allQuotationComponentsBasedOnId(id);
	}

	@Override
	public Quotation findQuotationBasedOnComponentId(int id) 
	{
		Quotation quotation = quotationRepository.findById(id).get();
		return quotation;
	}

	@Override
	public void deleteComponent(int id) 
	{
		quotationRepository.deleteById(id);
	}
	
}
