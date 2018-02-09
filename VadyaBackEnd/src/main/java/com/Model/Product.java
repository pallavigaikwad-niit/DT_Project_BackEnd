package com.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table(name="Product")
public class Product {	
	@Id
	@GeneratedValue
	@Column(name="pid")
	private int pid;
	@NotNull
	@Column(name="productName")
	private String productName;
	@NotNull
	@Column(name="productDiscription")
	private String productDescription;
	@NotNull
	@Column(name="price")
	private Float price;
	@NotNull
	@Column(name="stock")
	private Integer stock;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "cid")
	private Category category;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "sid")
	private Supplier supplier;
	
	@Transient
	MultipartFile pimage;
	private String imageName;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
