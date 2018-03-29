package com.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cart implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int cartId;

	@Column(name = "cartProductId")
	private int cartProductId;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "cartPrice")
	private double cartPrice;

	@Column(name = "cartQty")
	private int cartQty;

	@Column(name = "cartImage")
	private String cartImage;

	@Column(name = "cartProductName")
	private String cartProductName;
	
	private String cartProductDesc;
	private int productStock;
	
	private Float totalPrice;

	public Cart() {
		super();
	}

	public Cart(int cartId, int cartProductId, User user, double cartPrice, int cartQty, String cartImage,
			String cartProductName, Float totalPrice) {
		super();
		this.cartId = cartId;
		this.cartProductId = cartProductId;
		this.user = user;
		this.cartPrice = cartPrice;
		this.cartQty = cartQty;
		this.cartImage = cartImage;
		this.cartProductName = cartProductName;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	
	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	public Float gettotalPrice(){
		return totalPrice;
	}
	
	public void setTotalPrice(Float totalPrice){
		this.totalPrice = totalPrice;
	}

	public String getCartProductDesc() {
		return cartProductDesc;
	}

	public void setCartProductDesc(String cartProductDesc) {
		this.cartProductDesc = cartProductDesc;
	}

	
}