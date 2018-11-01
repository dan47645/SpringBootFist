package com.springboot.SpringBootFirst.demo.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootFirst.demo.Service.UserService;
import com.springboot.SpringBootFirst.demo.bean.SysUser;
import com.springboot.SpringBootFirst.demo.bean.dto.SysUserDto;
import com.springboot.SpringBootFirst.demo.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public SysUserDto findByUserName(String userName) {
		SysUser sysUser = this.userDao.findByUserName(userName);
		SysUserDto sysUserDto = new SysUserDto();
		BeanUtils.copyProperties(sysUser, sysUserDto);
		return sysUserDto;
	}

	@Override
	public SysUserDto findByUserNameAndPwd(String userName, String pwd) {
		SysUser sysUser = this.userDao.findByUserNameAndPwd(userName,pwd);
		SysUserDto sysUserDto = new SysUserDto();
		if(sysUser==null){
			return null;
		}
		BeanUtils.copyProperties(sysUser, sysUserDto);
		return sysUserDto;
	}

}
