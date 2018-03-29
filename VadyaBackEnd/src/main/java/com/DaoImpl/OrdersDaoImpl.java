package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.OrdersDao;
import com.Model.Orders;

@Repository("ordersDao")
@Service
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public OrdersDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insert(Orders orders) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(orders);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Orders> getOrderByUserId(int user_uid){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Orders WHERE user_uid=:user_uid");
		query.setParameter("user_uid", user_uid);
		List<Orders> orderList =  query.list(); 
		return orderList;
	}

}