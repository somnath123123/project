package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CustomerDAO;

import com.ecomm.entity.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerDAO customerDAO;
	
	
	@RequestMapping(value="/showCustomer")
	public String showcustomer(Model m)
	{
		List<Customer> customerList=customerDAO.getCustomerDetails();
		m.addAttribute("customerList", customerList);
		return "Customer";
	}
	
	@RequestMapping(value="/InsertCustomer",method=RequestMethod.POST)
	public String insertcustomer(@RequestParam("logName")String loginName,@RequestParam("pass")String password,@RequestParam("custName")String customerName,@RequestParam("emailId")String emailId,@RequestParam("MobileNo")String mobileNo,@RequestParam("custDesc")String customerDesc,@RequestParam("Role")String role,Model m)
	{
		Customer customerObj=new Customer();
		
		customerObj.setLoginName(loginName);
		customerObj.setPassword(password);
		customerObj.setCustomerName(customerName);
		customerObj.setEmailId(emailId);
		customerObj.setMobileNo(mobileNo);
		customerObj.setCustomerAddr(customerDesc);
		customerObj.setRole(role);
		customerDAO.addCustomer(customerObj);
		
		List<Customer> customerList=customerDAO.getCustomerDetails();
		m.addAttribute("customerList", customerList);
		
		return "Customer";
	}
	
	@RequestMapping(value="/UpdateCustomer",method=RequestMethod.POST)
	public String updatecustomer(@RequestParam("custId")int customerId,@RequestParam("logName")String loginName,@RequestParam("pass")String password,@RequestParam("custName")String customerName,@RequestParam("emailId")String emailId,@RequestParam("MobileNo")String mobileNo,@RequestParam("custAddr")String customerAddr,@RequestParam("Role")String role,Model m)
	{
		Customer customerObj=customerDAO.getCustomer(customerId);
		
		customerObj.setLoginName(loginName);
		customerObj.setPassword(password);
		customerObj.setCustomerName(customerName);
		customerObj.setEmailId(emailId);
		customerObj.setMobileNo(mobileNo);
		customerObj.setCustomerAddr(customerAddr);
		customerObj.setRole(role);
		
		customerDAO.updateCustomer(customerObj);
		
		List<Customer> customerList=customerDAO.getCustomerDetails();
		m.addAttribute("customerList", customerList);
		
		return "Customer";
	}
	
	@RequestMapping(value="/deleteCustomer/{customerId}")
	public String deletecustomer(@PathVariable("customerId")int customerId,Model m)
	{
	Customer customerObj=customerDAO.getCustomer(customerId);
		customerDAO.deleteCustomer(customerObj);
		
		List<Customer> customerList=customerDAO.getCustomerDetails();
		m.addAttribute("customerList", customerList);
		
		return "Customer";
	}
	
	@RequestMapping(value="/editCustomer/{customerId}")
	public String editcustomer(@PathVariable("customerId")int customerId,Model m)
	{
		Customer customerObj=customerDAO.getCustomer(customerId);
		m.addAttribute("customer", customerObj);
		return "CustomerUpdate";
	}
}
