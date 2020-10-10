package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.entity.Supplier;


public class TestDBConnSupplier 
{

	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Kiran kumar");
		supplier.setSupplierDesc("wholesaler");
		
		SupplierDAO supplierDAO=(SupplierDAO)appContext.getBean("supplierDAO");
		if(supplierDAO.addSupplier(supplier))
		{
			System.out.println("Object Saved");
		}
		else
		{
			System.out.println("Problem Occured");
		}
	}
}
