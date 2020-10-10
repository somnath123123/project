package com.ecomm.dao;



import java.util.List;

import com.ecomm.entity.Customer;





public interface CustomerDAO 
{

	public boolean addCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public List<Customer> getCustomerDetails();
	public Customer getCustomer(int customerId);
}
