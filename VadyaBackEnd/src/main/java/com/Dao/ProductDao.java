package com.Dao;

import java.util.List;

import com.Model.Product;


public interface ProductDao {
	void insertProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Product product);

	Product getProduct(int id);

	List<Product> getAllProducts();
	
	List<Product> getProductsByCategotry(String cid);
}