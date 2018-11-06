package com.springboot.SpringBootFirst.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.SpringBootFirst.demo.Service.UserService;

@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;



 /*   @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证

    }*/
    
    /**
     * （一）自定义MyUsernamePasswordAuthenticationFilter主要为了form表单中的数据
     * （包含1和2）
     */
    @Autowired
    private UserService userService;
    @Bean
    public MyUsernamePasswordAuthenticationFilter loginFilter()
            throws Exception {
    	MyUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new MyUsernamePasswordAuthenticationFilter();
    	customUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(customSuccessHandler());
        customUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(customFailureHandler());
        
        //在MyUsernamePasswordAuthenticationFilter这个构造函数中配置连接url后，还要在这里进行配置才能使用
        customUsernamePasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user_login"));
        
    	customUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        customUsernamePasswordAuthenticationFilter.setUserService(userService);
        return customUsernamePasswordAuthenticationFilter;
    }
    
    /**
     * 1.重写MyUsernamePasswordAuthenticationFilter后要重新设置一下失败后的返回地址
     * @return
     */
    @Bean
    public FailureHandler customFailureHandler() {
        FailureHandler customFailureHandler = new FailureHandler();
        customFailureHandler.setDefaultFailureUrl("/login?error");
        return customFailureHandler;
    }

    /**
     * 2.重写MyUsernamePasswordAuthenticationFilter后要重新设置一下成功后的返回地址
     * @return
     */
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
	        .anyRequest().authenticated() //任何请求,登录后才可以访问(Security验证权限时有一个缺陷:如果现在访问的url不在权限表中的时候，Security直接放行，这个设置可以防止这个问题的出现)
	        .and()
	        .formLogin().loginPage("/login").defaultSuccessUrl("/")
	        .failureUrl("/login?error").permitAll(); //登录页面用户任意访问
	        //.and().logout().permitAll() //注销行为任意访问
//	        .and()
//    		.exceptionHandling().accessDeniedPage("/access");
    	http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class).addFilter(loginFilter())
    		.csrf().disable();
    }
}