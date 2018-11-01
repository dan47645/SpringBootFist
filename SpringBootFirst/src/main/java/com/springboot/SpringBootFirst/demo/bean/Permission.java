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
@Table(name="sys_permission")
public class Permission extends Audited implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5293483512679685693L;

	//权限名称
	@Column(name="name")
    private String name;

    //权限描述
	@Column(name="descritpion")
    private String descritpion;

    //授权链接
	@Column(name="url")
    private String url;

    //父节点id
	@Column(name="pid")
    private int pid;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sys_permission_role",joinColumns=@JoinColumn(name="permission_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<SysRole> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}