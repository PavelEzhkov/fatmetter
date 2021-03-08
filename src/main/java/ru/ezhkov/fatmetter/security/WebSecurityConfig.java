package ru.ezhkov.fatmetter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static ru.ezhkov.fatmetter.security.ApplicationUserPermission.PRODUCT_WRITE;
import static ru.ezhkov.fatmetter.security.ApplicationUserRole.ADMIN;
import static ru.ezhkov.fatmetter.security.ApplicationUserRole.USER;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
               // .antMatchers("/products").hasAnyRole()
                .antMatchers( "/", "/index").permitAll()
               // .antMatchers(HttpMethod.PUT,"/products").hasAuthority(PRODUCT_WRITE.name())//.hasAnyRole(ADMIN.name())
                .anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .formLogin().defaultSuccessUrl("/products")
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable(); //todo switch on !!!
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("pass")).authorities(USER.getAuthorities()).roles(USER.name());
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("pass")).authorities(ADMIN.getAuthorities()).roles(ADMIN.name());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
