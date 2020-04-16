package com.example.testdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *  * @ClassName: SpringSecurityConfig
 *  * @Description: spring security 通过代码配置的方式设置用户名及密码
 *  * @Author: HeJin
 *  * @Date: 2020\4\16 0016 11:07
 *  * @Version: v1.0 文件初始创建
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").roles("admin").password("$2a$10$Q3EysO9XWvSXMSB085xKUOuFEHjYWr/jhhIgyUX6MMt3bcP/ZjnZW")
                .and()
                .withUser("admin1").roles("user").password("$2a$10$Q3EysO9XWvSXMSB085xKUOuFEHjYWr/jhhIgyUX6MMt3bcP/ZjnZW");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
