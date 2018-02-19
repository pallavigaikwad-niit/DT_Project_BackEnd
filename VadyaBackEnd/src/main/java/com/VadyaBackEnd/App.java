package com.VadyaBackEnd;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.Dao.CategoryDao;
import com.Dao.UserDao;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Category;
import com.Model.User;
import com.config.HibernateConfig;
public class App 
{
	private static UserDao userDao;
	private static CategoryDao categoryDao;
	private  static HibernateConfig config;
    public static void main( String[] args )
    {
    	System.out.println("Backend Running Fine");
    
    	config = new HibernateConfig();
    	/*    
    	categoryDao=new CategoryDaoImpl(config.getSessionFactory(config.getH2DataSource()));
    	Category category=new Category();
    	category.setCid("d1");
    	category.setCname("D1");
    	categoryDao.insertCategory(category);
    	*/
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
		
    	User u = new User();
    	//u.setUid(1);
    	u.setEmail("pallavi");
    	u.setPassword("123");
    	u.setAddress("Mumbai");
    	u.setPhone("12345");
    	//u.setEnabled("TRUE");
    	//u.setRole("ADMIN");
		userDao.insertUser(u);
		List<User> usersList = new ArrayList<User>();
		usersList = userDao.getAllUsers();
		if (usersList.isEmpty()) {
			System.out.println("No records found");
		} else {
			for (User user : usersList) {
				System.out.println("Email : " + user.getEmail() + ", Address: " + user.getAddress());
			}
		}
    }
}
