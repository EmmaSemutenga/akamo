package com.example.crudapp.configurations;

import com.example.crudapp.services.CustomSuccessHandler;
import com.example.crudapp.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(c -> c.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/admin-page","/registration","/add-student","/students","/securityguards","/add-securityguard","/resparents","/add-resparent","/parents","/add-parent","/delete-daypass/{id}").hasAuthority("ADMIN")
                        .requestMatchers("/edit-daypass/{id}","/daypasses").hasAnyAuthority("ADMIN","PARENT","RESPARENT","GUARD")
                        .requestMatchers("/parent-page").hasAuthority("PARENT")
                        .requestMatchers("/resparent-page").hasAuthority("RESPARENT")
                        .requestMatchers("/student-page","/add-daypass").hasAuthority("STUDENT")
                        .requestMatchers("/guard-page").hasAuthority("GUARD")
//                        .requestMatchers("/registration").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").successHandler(customSuccessHandler).permitAll())
                .logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout").permitAll());
        return http.build();
    }

    @Autowired
    public void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
