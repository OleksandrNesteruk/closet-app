package sringboot.garderobapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register", "/inject").permitAll()
                .requestMatchers(HttpMethod.POST, "/closet/add-clothing").hasRole("USER")
                .requestMatchers(HttpMethod.PUT, "/closet/update-clothing/{id}").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE, "/closet/delete-clothing/{id}").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/closet/by-user").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/clothing").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated().and()
                .formLogin().permitAll()
                .and()
                .httpBasic();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
