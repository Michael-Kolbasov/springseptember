package com.epam.spring.config.security.jdbc;

import com.epam.spring.enums.UserRole;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.epam.spring.enums.UserRole.ADMIN;
import static com.epam.spring.enums.UserRole.USER;

@Configuration
@EnableWebSecurity
@Profile({"securityjdbc", "default", "!securityinmemory"})
//@EnableGlobalMethodSecurity(securedEnabled = true) // enables method-level @Secured protection
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Setter(onMethod_= {@Autowired})
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/encode", "/principal").permitAll()
                .antMatchers("/cats/save").hasAuthority(str(USER))
                .antMatchers("/cats/**").hasAuthority(str(ADMIN))
                .antMatchers("/registration").anonymous()
                .anyRequest().authenticated()
                .and()
            .formLogin().permitAll()
                    //.loginPage("/login")
                    //.failureForwardUrl("/login?error")
                    .and()
            .logout().permitAll()
                //these are defaults
                .invalidateHttpSession(true)
                .clearAuthentication(true);
                //.logoutUrl("/logout")
                //.logoutSuccessUrl("/login?logout")
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    private String str(UserRole userRole) {
        return userRole.getAuthority();
    }
}