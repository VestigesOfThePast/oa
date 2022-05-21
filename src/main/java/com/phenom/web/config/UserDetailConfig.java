package com.phenom.web.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author olic
 * @date 2022/2/244:48 下午
 */
@Service
public class UserDetailConfig implements UserDetailsService {
    /**
     * 1、获取用户信息调用关系
     * UsernamePasswordAuthenticationFilter-->AuthenticationProvider-->DaoAuthenticationProvider-->UserDetailsService
     * 2、密码比对
     * DaoAuthenticationProvider使用密码管理器进行密码比对
     * 3、填充密码
     * 填充Authentication并返回
    */
     @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = User.withUsername("olic").password("$2a$10$1QY3HqrBFCIBh2B4UT8XJeX.HQYmNYrJM.M1PQwxdYKbAImKDAHa2").authorities("p1").build();
        return userDetails;
    }
}
