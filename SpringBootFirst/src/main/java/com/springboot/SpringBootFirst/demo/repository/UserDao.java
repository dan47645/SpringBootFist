package com.springboot.SpringBootFirst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.SpringBootFirst.demo.bean.SysUser;

public interface UserDao extends JpaRepository<SysUser, String>,JpaSpecificationExecutor<SysUser> {
	
	@Query("select u from SysUser u where u.username =:userName")
	SysUser findByUserName(@Param("userName") String userName);
}
