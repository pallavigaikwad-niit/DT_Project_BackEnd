package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.Model.Category;

@Repository("categoryDao")
@Service
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	//@Transactional
	public void insertCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		session.close();

	}

	//@Transactional
	public void updateCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		session.close();
	}

	//@Transactional
	public void deleteCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		session.close();
	}

	//@Transactional
	public Category getCategory(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category=session.get(Category.class, id);
		return category;
	}

	//@Transactional
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Category");
		List<Category> categoriesList = query.list();
		return categoriesList;
	}
}
