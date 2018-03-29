package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue
	@Column(name="uid")
	private int uid;
	@NotNull
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="address")
	private String address;
	@NotNull
	@Column(name="phone")
	private String phone;
	@NotNull
	@Column(name="enabled")
	private String enabled="TRUE";
	@NotNull
	@Column(name="role")
	private String role="ROLE_USER";	
	
	public User() {
		super();
	}
	public User(String email, String password, String address, String phone, String enabled, String role) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.enabled = enabled;
		this.role = role;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
