package com.ecomm.test;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.entity.Category;



public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		categoryDAO=(CategoryDAO)appContext.getBean("categoryDAO");
	}


@Test
public void addCategory()
{
	Category category=new Category();
	category.setCategoryName("Samsung A50");
	category.setCategoryDesc("All Models of SamsungA50 mobiles");
	
	assertTrue("Problem in Inserting Category",categoryDAO.addCategory(category));
}


@Test
public void getCategoryTest()
{
	Category category=(Category)categoryDAO.getCategory(4);
	assertNotNull("category object not Found",category);
	System.out.println("Category Name:"+category.getCategoryName());
	System.out.println("Category Desc:"+category.getCategoryDesc());
}

@Test
public void getCategoryList()
{
	List<Category> categoryList=(List<Category>)categoryDAO.getCategoryDetails();
	
	for(Category category:categoryList)
	{
		System.out.print("Category Name:"+category.getCategoryName());
		System.out.println("::::Category Desc:"+category.getCategoryDesc());
	}
}
}
