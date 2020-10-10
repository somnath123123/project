package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;

import com.ecomm.entity.Supplier;


public  class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		supplierDAO=(SupplierDAO)appContext.getBean("supplierDAO");
	}


@Test
public void addSupplier()
{
	Supplier supplier=new Supplier();
	supplier.setSupplierName("karthik");
	supplier.setSupplierDesc("ABC");
	
	assertTrue("Problem in Inserting supplier",supplierDAO.addSupplier(supplier));
}



@Test
public void getsupplierTest()
{
	Supplier supplier=(Supplier)supplierDAO.getSupplier(1);
	assertNotNull("supplier object not Found",supplier);
	System.out.println("supplier Name:"+supplier.getSupplierName());
	System.out.println("supplier Addr:"+supplier.getSupplierDesc());
}

@Test
public void getsupplierList()
{
	List<Supplier> supplierList=(List<Supplier>)supplierDAO.getSupplierDetails();
	
	for(Supplier supplier:supplierList)
	{
		System.out.print("supplier Name:"+supplier.getSupplierName());
		System.out.println("::::supplier Addr:"+supplier.getSupplierDesc());
	}
}
}

