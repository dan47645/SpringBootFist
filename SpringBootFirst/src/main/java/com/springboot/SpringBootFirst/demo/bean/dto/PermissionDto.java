package com.springboot.SpringBootFirst.demo.bean.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.springboot.SpringBootFirst.demo.util.QueryBase;
public class PermissionDto extends QueryBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -319326580443835172L;

	private String id;

	protected String createdBy;
	
	protected Calendar createdDate;
	
	protected String modifiedBy;
	
	protected Calendar modifiedDate;
    
	private String name;
    
	private String descritpion;
    
	private String url;
    
	private int pid;
	
	

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