package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;
import com.Model.Supplier;

@Repository("SupplierDao")
@Transactional
@Service
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void insertSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		session.close();
		
	}

	@Transactional
	public void updateSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(supplier);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public void deleteSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(supplier);
		session.getTransaction().commit();
	}
	
	@Transactional
	public List<Supplier> getAllSuppliers(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Supplier> query = session.createQuery("FROM Supplier");
		List<Supplier> supplierList = query.list();
		session.getTransaction().commit();
		return supplierList;
	}

	@Transactional
	public Supplier getSupplier(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier = session.get(Supplier.class, id);
		session.getTransaction().commit();
		return supplier;
	}
}
