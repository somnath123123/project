package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.entity.Supplier;


@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	
	@RequestMapping(value="/showSupplier")
	public String showsupplier(Model m)
	{
		List<Supplier> supplierList=supplierDAO.getSupplierDetails();
		m.addAttribute("supplierList", supplierList);
		return "Supplier";
	}
	
	@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
	public String insertsupplier(@RequestParam("supName")String supplierName,@RequestParam("supDesc")String supplierDesc,Model m)
	{
		Supplier supplierObj=new Supplier();
		supplierObj.setSupplierName(supplierName);
		supplierObj.setSupplierDesc(supplierDesc);
		
		supplierDAO.addSupplier(supplierObj);
		
		List<Supplier> supplierList=supplierDAO.getSupplierDetails();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updatesupplier(@RequestParam("supId")int supplierId,@RequestParam("supName")String supplierName,@RequestParam("supDesc")String supplierDesc,Model m)
	{
		Supplier supplierObj=supplierDAO.getSupplier(supplierId);
		supplierObj.setSupplierName(supplierName);
		supplierObj.setSupplierDesc(supplierDesc);
		
		supplierDAO.updateSupplier(supplierObj);
		
		List<Supplier> supplierList=supplierDAO.getSupplierDetails();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deletesupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
	Supplier supplierObj=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplierObj);
		
		List<Supplier> supplierList=supplierDAO.getSupplierDetails();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editsupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplierObj=supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplier", supplierObj);
		return "SupplierUpdate";
	}
}
