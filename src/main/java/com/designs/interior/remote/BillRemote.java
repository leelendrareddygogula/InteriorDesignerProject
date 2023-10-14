package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.Bill;

public interface BillRemote 
{
	public String addBillComponent(Bill bill);
	public List<Bill> getAllBillsOnBillId(int id);
	public void deleteBasedOnId(int id);
	public Bill getBillComponentBasedOnId(int id);
}
