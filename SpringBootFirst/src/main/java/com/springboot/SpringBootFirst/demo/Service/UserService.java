package com.springboot.SpringBootFirst.demo.Service;

import com.springboot.SpringBootFirst.demo.bean.dto.SysUserDto;

public interface UserService {
	public SysUserDto findByUserName(String userName);
	
	public SysUserDto findByUserNameAndPwd(String userName,String pwd);
}
