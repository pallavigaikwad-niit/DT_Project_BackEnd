package com.Dao;

import java.util.List;

import com.Model.Supplier;

public interface SupplierDao {
	public void insertSupplier(Supplier supplier);
	
	void updateSupplier(Supplier supplier);

	void deleteSupplier(Supplier supplier);
	
	List<Supplier> getAllSuppliers();
	
	Supplier getSupplier(String id);
}