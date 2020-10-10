package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.ProductDAO;

import com.ecomm.entity.Product;


@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping(value="/showProduct")
	public String showProduct(Model m)
	{
		List<Product> productList=productDAO.getProductDetails();
		m.addAttribute("productList", productList);
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertproduct(@RequestParam("prodName")String productName,@RequestParam("prodDesc")String productDesc,Model m)
	{
		Product productObj=new Product();
		productObj.setProductName(productName);
		productObj.setProductDesc(productDesc);
		
		productDAO.addProduct(productObj);
		
		List<Product> productList=productDAO.getProductDetails();
		m.addAttribute("productList", productList);
		
		return "Product";
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateproduct(@RequestParam("prodId")int productId,@RequestParam("prodName")String productName,@RequestParam("prodDesc")String productDesc,Model m)
	{
		Product productObj=productDAO.getProduct(productId);
		productObj.setProductName(productName);
		productObj.setProductDesc(productDesc);
		
		productDAO.updateProduct(productObj);
		
		List<Product> productList=productDAO.getProductDetails();
		m.addAttribute("productList", productList);
		
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteproduct(@PathVariable("productId")int productId,Model m)
	{
	Product productObj=productDAO.getProduct(productId);
		productDAO.deleteProduct(productObj);
		
		List<Product> productList=productDAO.getProductDetails();
		m.addAttribute("productList", productList);
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editproduct(@PathVariable("productId")int productId,Model m)
	{
		Product productObj=productDAO.getProduct(productId);
		m.addAttribute("product", productObj);
		return "ProductUpdate";
	}
}
