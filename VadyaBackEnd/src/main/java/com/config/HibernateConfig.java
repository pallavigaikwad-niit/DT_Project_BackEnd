package com.config;


import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Dao.*;
import com.DaoImpl.*;
import com.Model.*;

@Configuration
@EnableTransactionManagement
@ComponentScan("com")

public class HibernateConfig {
	
	//public static SessionFactory sessionFactory = null;
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource driverMgrDataSource=new DriverManagerDataSource();
		driverMgrDataSource.setDriverClassName("org.h2.Driver");
		driverMgrDataSource.setUrl("jdbc:h2:tcp://localhost/~/VadyaDB");
		driverMgrDataSource.setUsername("sa");
		driverMgrDataSource.setPassword("");
		return driverMgrDataSource;
	}
	private Properties getHibernetProp()
	{
		Properties hibernateProperties=new Properties();
		//hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults","false");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.auto","none");
		hibernateProperties.put("hibernate.show_sql", "true");
		return hibernateProperties;
		
	}
	@SuppressWarnings("deprecation")
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder localSessionFacBuilder=new LocalSessionFactoryBuilder(datasource);
		localSessionFacBuilder.addProperties(getHibernetProp());
		localSessionFacBuilder.scanPackages("com.Model");
		localSessionFacBuilder.addAnnotatedClass(User.class);
		localSessionFacBuilder.addAnnotatedClass(Category.class);
		localSessionFacBuilder.addAnnotatedClass(Supplier.class);
		localSessionFacBuilder.addAnnotatedClass(Product.class);
		System.out.println("Session Factory Object Created");
		return localSessionFacBuilder.buildSessionFactory();
		
	}
	
	@Autowired
	@Bean(name="UserDaoImpl")
	public UserDaoImpl getUserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="SupplierDaoImpl")
	public SupplierDaoImpl getSupplierData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="CategoryDaoImpl")
	public CategoryDaoImpl getCategoryData(SessionFactory sf)
	{
		return new CategoryDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="productDaoImpl")
	public ProductDaoImpl getProductData(SessionFactory sf){
		return new ProductDaoImpl(sf);
	}
	
	//Transaction Bean Object
	@Autowired 
	@Bean(name="transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTranMgr=new HibernateTransactionManager(sessionFactory);
		//hibernateTranMgr.setSessionFactory(sessionFactory);
		return hibernateTranMgr;
	}
	
}
