package com.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Category;
import com.Model.Product;
import com.Model.Supplier;
import com.Model.User;

@Configuration
@ComponentScan(basePackages= {"com"})
@EnableTransactionManagement
public class HibernateConfig {
	
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/VadyaDB");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
		private Properties getHibernetProp()
	{
			System.out.println("Get Prop Method");
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults","false");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.auto","none");
		hibernateProperties.put("hibernate.show_sql", "true");
		return hibernateProperties;
		
	}			
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(getH2DataSource());
		//System.out.println("Step 1");
		sessionFactory.addProperties(getHibernetProp());
		//System.out.println("Step 2");
		sessionFactory.scanPackages("com.Model");
		//System.out.println("Step 3");
		sessionFactory.addAnnotatedClasses(User.class);
		sessionFactory.addAnnotatedClasses(Category.class);
		sessionFactory.addAnnotatedClasses(Supplier.class);
		sessionFactory.addAnnotatedClasses(Product.class);
		System.out.println("Session Factory Object Created");
		return sessionFactory.buildSessionFactory();		
	}
	
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl getUserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl getSupplierData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="categoryDaoImpl")
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
	public HibernateTransactionManager getTransactionManager(SessionFactory sf)
	{
		HibernateTransactionManager hibernateTranMgr=new HibernateTransactionManager(sf);
		hibernateTranMgr.setSessionFactory(sf);
		return hibernateTranMgr;
	}
	
}
