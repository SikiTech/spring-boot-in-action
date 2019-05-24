/**
 * projectName: spring-boot-in-action
 * fileName: SecurityPermitAllConfig.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-23 下午8:55
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @className: SecurityPermitAllConfig
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: 权限配置
 * @author: Robert
 * @data: 2019-05-23 下午8:55
 * @version: V1.0
 **/
@Profile("dev")
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }
}