package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.BillSummary;

public interface BillSummaryRemote 
{
	public String insertBillSummary(BillSummary billSummary);
	public int nextBillId();
	public List<BillSummary> getAllBillRecords();
	public BillSummary getBillDetailsUsingBillId(int id);
}
