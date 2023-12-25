package com.sz.springcloudsamples.common.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security配置类
 *
 * @author Yanghj
 * @date 1/3/2020
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DefaultWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Value("${security.csrf.enabled:true}")
    private boolean csrfEnabled;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/actuator/**");
        if (!csrfEnabled) {
            http.csrf().disable();
        }
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.toAnyEndpoint())
                .hasRole("ACTUATOR_ADMIN")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                .antMatchers(
                        "/", "/error", "/swagger-ui.html", "/v2/api-docs", "/swagger-resources/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
