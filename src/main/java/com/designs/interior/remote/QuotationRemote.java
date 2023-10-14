package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.Quotation;

public interface QuotationRemote 
{
	public void addAQuotationComponent(Quotation quotation);
	public int maxQuotationIdTillNow();
	public List<Quotation> getCustomerQuotationBasedOnQId(int id);
	public Quotation findQuotationBasedOnComponentId(int id);
	public void deleteComponent(int id);
}
