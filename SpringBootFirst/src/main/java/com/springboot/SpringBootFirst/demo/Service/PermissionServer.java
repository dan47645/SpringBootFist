package com.springboot.SpringBootFirst.demo.Service;

import java.util.List;

import com.springboot.SpringBootFirst.demo.bean.dto.PermissionDto;

public interface PermissionServer {
	public List<PermissionDto> findAll();
	public PermissionDto findById(String id);
	public List<PermissionDto> findByUserId(String id);
}
