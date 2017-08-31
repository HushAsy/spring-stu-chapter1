package org.hhs;

import org.hhs.repositories.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by hewater on 2017/8/30.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureForwardUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//                return noticeRepository.findAll();
                return null;
            }
        });
    }
}
