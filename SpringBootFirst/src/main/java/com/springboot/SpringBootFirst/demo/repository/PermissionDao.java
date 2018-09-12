package com.springboot.SpringBootFirst.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.SpringBootFirst.demo.bean.Permission;

public interface PermissionDao extends JpaRepository<Permission, String>,JpaSpecificationExecutor<Permission> {
	
}