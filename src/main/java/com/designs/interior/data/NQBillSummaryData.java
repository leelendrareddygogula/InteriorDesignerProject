package com.designs.interior.data;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.NQBillSummary;
import com.designs.interior.remote.NQBillSummaryRemote;
import com.designs.interior.repository.NQBillSummaryRepository;

@Service
public class NQBillSummaryData implements NQBillSummaryRemote
{
	
	@Autowired
	private NQBillSummaryRepository nqBillSummaryRepository;
	
	@Override
	public String addBNQBillSummary(NQBillSummary nqBillSummary) 
	{
		nqBillSummaryRepository.save(nqBillSummary);
		return "Bill saved successfully with name " + nqBillSummary.getCustomerName() + " and id " + nqBillSummary.getId();
	}

	@Override
	public int getMaxNQBillSummaryId() 
	{
		int val;
		try
		{
			val = nqBillSummaryRepository.getMaxIdOfNQBillSummary();
		}
		catch (AopInvocationException e) {
			return 10000;
		}
		return val + 1;
	}

	@Override
	public List<NQBillSummary> getAllNQBillSummaries() 
	{
		return nqBillSummaryRepository.allNQBillSummary();
	}

	@Override
	public NQBillSummary getSummaryBasedOnId(int id) {
		NQBillSummary billSummary = nqBillSummaryRepository.findById(id).get();
		return billSummary;
	}
	
}
