package com.VadyaBackEnd;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Model.User;
import com.config.HibernateConfig;

/**
 * Hello world!
 *
 */
public class App 
{
	private static UserDao userDao;
	private  static HibernateConfig config;
    public static void main( String[] args )
    {
    	config = new HibernateConfig();
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
		
    	User u = new User();
    	//u.setUid(1);
    	
    	u.setEmail("pallavi");
    	u.setPassword("123");
    	u.setAddress("Mumbai");
    	u.setPhone("12345");
    	u.setEnabled("TRUE");
    	u.setRole("ADMIN");
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
