package com.springboot.SpringBootFirst.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootFirst.demo.Service.PermissionServer;
import com.springboot.SpringBootFirst.demo.Service.UserService;
import com.springboot.SpringBootFirst.demo.bean.dto.PermissionDto;
import com.springboot.SpringBootFirst.demo.bean.dto.SysUserDto;

@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserService userService;
    @Autowired
    PermissionServer permissionServer;

    public UserDetails loadUserByUsername(String username) {
        SysUserDto user = userService.findByUserName(username);
        if (user != null) {
            List<PermissionDto> permissions = permissionServer.findByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <GrantedAuthority>();
            for (PermissionDto permission : permissions) {
                if (permission != null && permission.getName()!=null) {
	                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
	                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
	                grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}