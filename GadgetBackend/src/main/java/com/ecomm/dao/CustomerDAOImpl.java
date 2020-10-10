package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.entity.Customer;


@Transactional
@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO
{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCustomer(Customer customer) {
		try
		{
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try
		{
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try
		{
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Customer> getCustomerDetails() 
	{
		Session session=sessionFactory.openSession();
		List<Customer> customerList=session.createQuery("from Customer").list();
		session.close();
		return customerList;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session=sessionFactory.openSession();
		Customer customer=session.get(Customer.class,customerId);
		session.close();
		return customer;
	}

}
