package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.NQBill;

public interface NQBillRemote 
{
	public void addNQBillComponent(NQBill nqBill);
	public void deleteNQBillComponent(int id);
	public List<NQBill> getBillsBasedOnId(int id);
	public NQBill getComponentOnId(int id);
}
