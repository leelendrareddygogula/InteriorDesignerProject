package com.designs.interior.data;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.BillSummary;
import com.designs.interior.remote.BillSummaryRemote;
import com.designs.interior.repository.BillSummaryRepository;

@Service
public class BillSummaryData implements BillSummaryRemote
{
	@Autowired
	private BillSummaryRepository billSummaryRepository;

	@Override
	public String insertBillSummary(BillSummary billSummary) 
	{
		String s = "";
		billSummaryRepository.save(billSummary);
		s = "Bill Saved Successfully with bill ID "+billSummary.getBillId() + " with name, " +billSummary.getCustomerName();
		return s;
	}

	@Override
	public int nextBillId() 
	{
		int id;
		try
		{
			id = billSummaryRepository.getMaxBillSummaryId();
			id += 1;
		}
		catch (AopInvocationException e) {
			id = 10000; //Executes when there are no records in table
		}
		return id;
	}

	@Override
	public List<BillSummary> getAllBillRecords()
	{
		return billSummaryRepository.getBillSummaryOrderedById();
	}

	@Override
	public BillSummary getBillDetailsUsingBillId(int id) 
	{
		return billSummaryRepository.findById(id).get();
	}
	
}
