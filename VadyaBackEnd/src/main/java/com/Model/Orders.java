package com.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component 
@Entity
public class Orders implements Serializable{
			

	private static final long serialVersionUID = 1L;

		@GeneratedValue
		@Id
		@Column(name="orderId")
		private int orderId;
		
		@ManyToOne
		//@JoinColumn(name="userid")
		private User user;
		
		@Column(name="paymentMode")
		private String paymentMode;
		
		@Column(name="totalAmount")
		private double totalAmount;
		
		@Temporal(TemporalType.DATE)
		private Date orderDate;
		
		public Orders(){super();}

		public Orders( int orderId,User user, String paymentMode, double totalAmount, Date orderDate) {
			super();
			this.orderId = orderId;
			this.user = user;
			this.paymentMode = paymentMode;
			this.totalAmount = totalAmount;
			this.orderDate = orderDate;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}		
}