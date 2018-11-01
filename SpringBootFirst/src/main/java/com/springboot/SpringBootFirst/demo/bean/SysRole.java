package com.springboot.SpringBootFirst.demo.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.springboot.SpringBootFirst.demo.util.Audited;

@Entity
@Table(name="sys_role")
public class SysRole extends Audited implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4459846996359613618L;
	
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sys_role_user",joinColumns=@JoinColumn(name="sys_role_id"),
			inverseJoinColumns=@JoinColumn(name="sys_user_id"))
	private List<SysUser> users;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sys_permission_role",joinColumns=@JoinColumn(name="role_id"),
			inverseJoinColumns=@JoinColumn(name="permission_id"))
	private List<Permission> permissions;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SysUser> getUsers() {
		return users;
	}

	public void setUsers(List<SysUser> users) {
		this.users = users;
	}
	
	
}
