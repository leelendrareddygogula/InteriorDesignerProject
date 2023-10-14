package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.NQBillSummary;

public interface NQBillSummaryRemote 
{
	public String addBNQBillSummary(NQBillSummary nqBillSummary);
	public int getMaxNQBillSummaryId();
	public List<NQBillSummary> getAllNQBillSummaries();
	public NQBillSummary getSummaryBasedOnId(int id);
}
