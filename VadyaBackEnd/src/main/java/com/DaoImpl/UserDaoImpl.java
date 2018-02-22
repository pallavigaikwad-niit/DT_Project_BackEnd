package com.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.Model.User;

@Repository("userDao")
@Service
public class UserDaoImpl implements UserDao {

	//private HibernateConfig config;
	
	@Autowired
	SessionFactory sessionFactory;

	
	public UserDaoImpl() {
		super();
	}

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	//@Transactional
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(user);
		} catch (Exception e) {
			System.out.println("INSERT :" + e);
		}
		session.getTransaction().commit();
		session.close();
	}

	//@Transactional
	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();

	}

	//@Transactional
	public void deleteUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	//@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<User> query = session.createQuery("FROM User");
		userList = query.list();
		session.getTransaction().commit();
		session.close();
		return userList;
	}

	//@Transactional
	public User getUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}
}