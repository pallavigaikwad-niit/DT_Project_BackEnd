package com.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Supplier")
public class Supplier {
	
	@Id
	@Column(name="sid")
	private String sid;
	
	@NotNull
	@Column(name="supplierName")
	private String supplierName;

	@OneToMany(targetEntity=Product.class, fetch= FetchType.EAGER, mappedBy = "supplier" )
	private Set<Product> products = new HashSet<Product>(0);
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	
}