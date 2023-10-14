package com.designs.interior.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designs.interior.entity.NQBill;
import com.designs.interior.remote.NQBillRemote;
import com.designs.interior.repository.NQBillRepository;

@Service
public class NQBillData implements NQBillRemote
{

	@Autowired
	private NQBillRepository nqBillRepository;
	
	@Override
	public void addNQBillComponent(NQBill nqBill) 
	{
		nqBillRepository.save(nqBill);
	}

	@Override
	public void deleteNQBillComponent(int id) 
	{
		nqBillRepository.deleteById(id);
	}

	@Override
	public List<NQBill> getBillsBasedOnId(int id) 
	{
		return nqBillRepository.getAllBillsBasedOnId(id);
	}

	@Override
	public NQBill getComponentOnId(int id) 
	{
		NQBill bill = nqBillRepository.findById(id).get();
		return bill;
	}
	
}
