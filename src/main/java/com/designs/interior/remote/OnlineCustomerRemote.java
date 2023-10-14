package com.designs.interior.remote;

import java.util.List;

import com.designs.interior.entity.OnlineCustomer;

public interface OnlineCustomerRemote 
{
	public void addOnlineCustomer(OnlineCustomer customer);
	public void deleteOnlineCustomerById(int id);
	public List<OnlineCustomer> getAllOnlineCustomersByStatus(boolean type);
	public OnlineCustomer getById(int id);
}
