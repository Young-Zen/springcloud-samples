package com.sz.springcloudsamples.admin.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

/**
 * Admin Server Security配置类
 *
 * @author Yanghj
 * @date 1/11/2020
 */
@Configuration
public class AdminServerWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public AdminServerWebSecurityConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        http.authorizeRequests()
                // Grants public access to all static assets and the login page.
                .antMatchers(adminContextPath + "/assets/**")
                .permitAll()
                .antMatchers(adminContextPath + "/login")
                .permitAll()
                // Every other request must be authenticated.
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage(adminContextPath + "/login")
                .successHandler(successHandler)
                .and()
                // Configures login and logout.
                .logout()
                .logoutUrl(adminContextPath + "/logout")
                .and()
                // Enables HTTP-Basic support. This is needed for the Spring Boot Admin Client to
                // register.
                .httpBasic()
                .and()
                .csrf()
                // Enables CSRF-Protection using Cookies
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(
                        // Disables CRSF-Protection the endpoint the Spring Boot Admin Client uses
                        // to register.
                        adminContextPath + "/instances",
                        // Disables CRSF-Protection for the actuator endpoints.
                        adminContextPath + "/actuator/**");
        // @formatter:on
    }
}
