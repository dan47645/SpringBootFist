package com.springboot.SpringBootFirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * 启动类;
 * @author 
 * @version v.0.1  
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer  {

    public static void main(String[] args) {
       SpringApplication.run(App.class, args);
    }
}
