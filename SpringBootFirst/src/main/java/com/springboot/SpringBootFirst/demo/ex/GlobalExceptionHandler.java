package com.springboot.SpringBootFirst.demo.ex;

import com.alibaba.fastjson.util.IOUtils;
import com.springboot.SpringBootFirst.demo.util.ResultObject;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 项目统一异常处理
 * 	测试了很多遍，只能连接@requsetMapping()这个种类型抛出的异常，不适合应用在整个框架上捕获异常，只适合业务上捕捉异常
 * @author Luo
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	public GlobalExceptionHandler() {
		 System.out.println("=====================已经扫描到了，被加载了 =======================");
	}

	@ExceptionHandler({ Exception.class })
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        System.out.println("=====================全局异常信息捕获=======================");

        String msg;
       /* if(ex instanceof BusinessException){
            msg = ex.getMessage();
        } else {
            msg = "操作异常!";
        }*/
        ex.printStackTrace();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //out.print(JSON.toJSON(ResultJson.buildFailInstance(msg)).toString());
            out.print(ex.getMessage());
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            IOUtils.close(out);
        }

        return null;
    }
    
    @ExceptionHandler(value = AccessDeniedException.class)
    public Object AccessDeniedExceptionHandler(AccessDeniedException exception) throws Exception {
        System.out.println(exception.getMessage());
    	ResultObject resultMsg = new ResultObject("权限不足！", "1");
        return resultMsg;
    }
    
}