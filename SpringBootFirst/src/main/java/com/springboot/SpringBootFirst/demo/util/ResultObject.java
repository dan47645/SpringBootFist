package com.springboot.SpringBootFirst.demo.util;

import com.alibaba.fastjson.JSON;

public class ResultObject {
	private String msg;
	private String code;
	
	public ResultObject() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultObject(String msg,String code){
		this.msg = msg;
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
