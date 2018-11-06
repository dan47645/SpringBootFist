package com.springboot.SpringBootFirst.demo.ex;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseErrorController extends AbstractErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);
	
	private static final String PATH = "/error"; 
	
	public BaseErrorController(ErrorAttributes errorAttributes) {
			super(errorAttributes);
	}
	
	@RequestMapping(value = PATH)
	public String  handleError(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, Object> errorAttr = this.getErrorAttributes(request, this.getTraceParameter(request));
		
		for(Map.Entry<String, Object> m : errorAttr.entrySet()){
			System.out.println("key:"+m.getKey()+" ----   value:"+m.getValue());
		}
		
		return null;
	}

	
	
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}


}