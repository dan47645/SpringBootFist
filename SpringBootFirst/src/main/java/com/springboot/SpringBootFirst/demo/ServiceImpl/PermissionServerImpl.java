package com.springboot.SpringBootFirst.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootFirst.demo.Service.PermissionServer;
import com.springboot.SpringBootFirst.demo.bean.Permission;
import com.springboot.SpringBootFirst.demo.bean.dto.PermissionDto;
import com.springboot.SpringBootFirst.demo.repository.PermissionDao;

@Service
public class PermissionServerImpl implements PermissionServer {
	
	@Autowired
	private PermissionDao permissionDao;
	
	@PersistenceContext  
    private EntityManager entityManager;

	@Override
	public List<PermissionDto> findAll() {
		List<Permission> permissionList = this.permissionDao.findAll();
		List<PermissionDto> permissionDtoList = permissionToPermissionDto(permissionList);
		return permissionDtoList;
	}

	@Override
	public PermissionDto findById(String id) {
		Permission permission = this.permissionDao.findOne(id);
		PermissionDto permissionDto = new PermissionDto();
		BeanUtils.copyProperties(permission, permissionDto);
		return permissionDto;
	}

	@Override
	public List<PermissionDto> findByUserId(String id) {
		StringBuilder sql = new StringBuilder(" select p.* from Sys_User u ");
		sql.append(" LEFT JOIN sys_role_user sru on u.id= sru.Sys_User_id ");
		sql.append(" LEFT JOIN Sys_Role r on sru.Sys_Role_id=r.id ");
		sql.append(" LEFT JOIN Sys_permission_role spr on spr.role_id=r.id ");
		sql.append(" LEFT JOIN Sys_permission p on p.id =spr.permission_id  where u.id = :id ");
	
		Query query = entityManager.createNativeQuery(sql.toString(),Permission.class);
		query.setParameter("id", id);
		List<Permission> permissionList = query.getResultList();
		List<PermissionDto> permissionDtoList = permissionToPermissionDto(permissionList);
		return permissionDtoList;
	}
	
	public List<PermissionDto> permissionToPermissionDto(List<Permission> permissionList){
		List<PermissionDto> permissionDtoList = new ArrayList<PermissionDto>();
		for(Permission p : permissionList){
			PermissionDto pDto = new PermissionDto();
			BeanUtils.copyProperties(p, pDto);
			permissionDtoList.add(pDto);
		}
		return permissionDtoList;
	}
	
}
