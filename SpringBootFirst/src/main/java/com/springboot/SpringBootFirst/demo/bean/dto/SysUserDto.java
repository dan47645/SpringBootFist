package com.springboot.SpringBootFirst.demo.bean.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.springboot.SpringBootFirst.demo.util.QueryBase;

public class SysUserDto extends QueryBase implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2578375836359653548L;
	
	private String id;

	protected String createdBy;
	
	protected Calendar createdDate;
	
	protected String modifiedBy;
	
	protected Calendar modifiedDate;

	private String username;
	
	private String password;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Calendar getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Calendar getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
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

