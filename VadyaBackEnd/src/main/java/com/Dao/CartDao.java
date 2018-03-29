package com.Dao;

import java.util.List;

import com.Model.Cart;

public interface CartDao {
	void insert(Cart cart);
	
	void updateCart(Cart cart);
	
	void deleteCart(int cartId);
	
	Cart getCartById(int cartId, String userEmail);
	
	List<Cart> findCartById(int uid);
	Cart getCartByProductId(int productId);
}