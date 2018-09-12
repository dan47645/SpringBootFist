package com.springboot.SpringBootFirst.demo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.springboot.SpringBootFirst.demo.util.Audited;
@Entity
@Table(name="sys_user")
public class SysUser extends Audited implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4880339655007103705L;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

