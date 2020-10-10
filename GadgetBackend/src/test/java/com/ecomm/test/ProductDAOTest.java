package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.entity.Product;


public class ProductDAOTest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		productDAO=(ProductDAO)appContext.getBean("productDAO");
	}


@Test
public void addproduct()
{
	Product product=new Product();
	product.setProductName("Samsun");
	product.setProductDesc("All Models of Samsun mobiles");
	
	assertTrue("Problem in Inserting product",productDAO.addProduct(product));
}


@Test
public void getproductTest()
{
	Product product=(Product)productDAO.getProduct(4);
	assertNotNull("product object not Found",product);
	System.out.println("product Name:"+product.getProductName());
	System.out.println("product Desc:"+product.getProductDesc());
}

@Test
public void getproductList()
{
	List<Product> productList=(List<Product>)productDAO.getProductDetails();
	
	for(Product product:productList)
	{
		System.out.print("product Name:"+product.getProductName());
		System.out.println("::::product Desc:"+product.getProductDesc());
	}
}
}


