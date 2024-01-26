package com.example.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.ris.services.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailService _UserDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf()
        .disable()
        .authorizeHttpRequests()
        .antMatchers("/registracija", "/").permitAll()
        .antMatchers("/registracija/**").permitAll()
                .antMatchers("/getposiljke").permitAll()
                .antMatchers("/posiljka/{idposiljke}").permitAll()
                .antMatchers("/editposiljka").hasAuthority("DOSTAVLJAC")
                .antMatchers("/dodajposiljku").hasAuthority("DOSTAVLJAC")
        .antMatchers("/addcategory").hasAuthority("ADMIN")
        .antMatchers("/adminpanel").hasAuthority("ADMIN")
                .antMatchers("/radnikpanel").hasAuthority("DOSTAVLJAC")
                .antMatchers("/superadminpanel").hasAuthority("SUPERADMIN")
                .antMatchers("/profile").hasAuthority("USER")
                .antMatchers("/radnikprofile").hasAnyAuthority("ADMIN", "DOSTAVLJAC", "SUPERADMIN")
        .antMatchers("/getokruzi").hasAuthority("ADMIN")
        .antMatchers("/getradnici").hasAuthority("ADMIN")
                .antMatchers("/getradnici/{idradnika}").hasAuthority("ADMIN")
                .antMatchers("/editradnik").hasAuthority("ADMIN")
                .antMatchers("/deleteradnik/{idradnika}").hasAuthority("ADMIN")
        .antMatchers("/dodajvozilo").hasAuthority("ADMIN")
                .antMatchers("/deleteokrug/{idokruga}").hasAuthority("ADMIN")
                .antMatchers("/editokrug").hasAuthority("ADMIN")
                .antMatchers("/dodajokrug").hasAuthority("ADMIN")
        .antMatchers("/editvozilo").hasAuthority("ADMIN")
                .antMatchers("/deletevozilo/{idvozila}").hasAuthority("ADMIN")
        .antMatchers("/css/**").permitAll()
        .antMatchers("/bootstrap/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .failureUrl("/login?error")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/", true)
            .permitAll())
        .logout(
            logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .permitAll())
        .rememberMe()
        .key("security-remember-secret")
        .tokenValiditySeconds(86400)
        .and()
        .userDetailsService(_UserDetailService)
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

