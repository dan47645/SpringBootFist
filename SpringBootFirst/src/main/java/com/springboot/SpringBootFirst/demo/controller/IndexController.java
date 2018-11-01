package com.springboot.SpringBootFirst.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.SpringBootFirst.demo.util.Msg;

@Controller
public class IndexController {
	
//	@RequestMapping(value="/")
//	public String index(){
//		return "index";
//	}
	
	@RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
        model.addAttribute("msg", msg);
        return "souye/include";
    }
	
	@RequestMapping("/login")
    public  String login(){
        return "login";
    }
	
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }

}
