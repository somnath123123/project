package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CustomerDAO;

import com.ecomm.entity.Customer;

public class TestDBConnCustomer 
{

	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		
		Customer customer=new Customer();
		customer.setLoginName("navnath");
		customer.setPassword("nava");
		customer.setCustomerName("navnath sabale");
		customer.setEmailId("navnath@gmail.com");
		customer.setMobileNo("992177556");
		customer.setCustomerAddr("Karad");
		customer.setRole("admin");
		
		CustomerDAO customerDAO=(CustomerDAO)appContext.getBean("customerDAO");
		if(customerDAO.addCustomer(customer))
		{
			System.out.println("Object Saved");
		}
		else
		{
			System.out.println("Problem Occured");
		}
	}
	
}
