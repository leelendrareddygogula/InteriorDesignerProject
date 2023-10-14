package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.Bill;
import com.designs.interior.remote.BillRemote;
import com.designs.interior.repository.BillRepository;

@Service
public class BillData implements BillRemote
{
	@Autowired
	private BillRepository billRepository;

	@Override
	public String addBillComponent(Bill bill) 
	{
		billRepository.save(bill);
		return "Component Saved Successfully";
	}
	
	@Override
	public List<Bill> getAllBillsOnBillId(int id) 
	{
		return billRepository.getAllBillComponentsUsingBillId(id);
	}

	@Override
	public void deleteBasedOnId(int id) 
	{
		billRepository.deleteById(id);
		return;
	}

	@Override
	public Bill getBillComponentBasedOnId(int id) 
	{
		return billRepository.findById(id).get();
	}
}
