package com.springboot.SpringBootFirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 启动类;
 * @author 
 * @version v.0.1  
 */
@SpringBootApplication
public class App extends WebMvcConfigurerAdapter  {

    public static void main(String[] args) {
       SpringApplication.run(App.class, args);
    }
}
