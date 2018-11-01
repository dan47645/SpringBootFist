package com.springboot.SpringBootFirst.demo.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sys_role_user",joinColumns=@JoinColumn(name="sys_user_id")
		,inverseJoinColumns=@JoinColumn(name="sys_role_id"))
	private List<SysRole> roles;
	
	
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
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

