package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.entity.Category;


@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value="/showCategory")
	public String showCategory(Model m)
	{
		List<Category> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category categoryObj=new Category();
		categoryObj.setCategoryName(categoryName);
		categoryObj.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(categoryObj);
		
		List<Category> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category categoryObj=categoryDAO.getCategory(categoryId);
		categoryObj.setCategoryName(categoryName);
		categoryObj.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(categoryObj);
		
		List<Category> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
	Category categoryObj=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(categoryObj);
		
		List<Category> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category categoryObj=categoryDAO.getCategory(categoryId);
		m.addAttribute("category", categoryObj);
		return "CategoryUpdate";
	}
}
