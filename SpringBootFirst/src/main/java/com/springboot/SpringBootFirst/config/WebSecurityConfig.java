package com.springboot.SpringBootFirst.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.springboot.SpringBootFirst.demo.Service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;



    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证

    }
    
    @Autowired
    private UserService userService;
    @Bean
    public MyUsernamePasswordAuthenticationFilter loginFilter()
            throws Exception {
    	MyUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new MyUsernamePasswordAuthenticationFilter();
    	customUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(customSuccessHandler());
        customUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(customFailureHandler());
    	customUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        customUsernamePasswordAuthenticationFilter.setUserService(userService);
        return customUsernamePasswordAuthenticationFilter;
    }
    
    @Bean
    public FailureHandler customFailureHandler() {
        FailureHandler customFailureHandler = new FailureHandler();
        customFailureHandler.setDefaultFailureUrl("/login?error");
        return customFailureHandler;
    }

    @Bean
    public SuccessHandler customSuccessHandler() {
        SuccessHandler customSuccessHandler = new SuccessHandler();
        customSuccessHandler.setDefaultTargetUrl("/");
        return customSuccessHandler;
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
	        .antMatchers("/css/**").permitAll()
	        .antMatchers("/js/**").permitAll()
	        .antMatchers("/dist/**").permitAll()
	        .antMatchers("/img/**").permitAll()
	        .anyRequest().authenticated() //任何请求,登录后可以访问
	        .and()
	        .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/")
	        .failureUrl("/login?error")
	        .permitAll() //登录页面用户任意访问
	        .and()
	        .logout().permitAll(); //注销行为任意访问
    	http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class).addFilter(loginFilter())
    		.csrf().disable();
    }
}