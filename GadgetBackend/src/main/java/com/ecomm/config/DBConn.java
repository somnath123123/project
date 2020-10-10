package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.entity.Category;
import com.ecomm.entity.Customer;

import com.ecomm.entity.Product;
import com.ecomm.entity.Supplier;



@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConn 
{
	@Bean
	public DataSource getMySQLDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/PROJECT");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		System.out.println("==Data Source Created===");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		
		LocalSessionFactoryBuilder factoryMgr=new LocalSessionFactoryBuilder(getMySQLDataSource());
		factoryMgr.addProperties(hibernateProp);
		
		factoryMgr.addAnnotatedClass(Category.class);
		factoryMgr.addAnnotatedClass(Customer.class);
		factoryMgr.addAnnotatedClass(Supplier.class);
		factoryMgr.addAnnotatedClass(Product.class);
		
		System.out.println("=== SessionFactory Object Created====");
		
		return factoryMgr.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager tranMgr=new HibernateTransactionManager(sessionFactory);
		System.out.println("==== Transaction Manager Object Created====");
		return tranMgr;
	}
}
