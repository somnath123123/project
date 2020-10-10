package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CredentialController 
{

	@RequestMapping(value="/SignIn")
	public String showLogin()
	{
		return "SignIn";
	}
	@RequestMapping(value="/SignUp")
	public String SignUp()
	{
		return "SignUp";
	}

	@RequestMapping(value="/AboutUs")
	public String AboutUs()
	{
		return "AboutUs";
	}
	@RequestMapping(value="/ContactUs")
	public String ContactUs()
	{
		return "ContactUs";
	}
	
}
