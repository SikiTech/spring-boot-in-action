/**
 * projectName: spring-boot-in-action
 * fileName: DruidConfig.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-17 下午2:27
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @className: DruidConfig
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: Druid 配置
 * @author: Robert
 * @data: 2019-05-17 下午2:27
 * @version: V1.0
 **/
//@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidServlet() { // 主要实现WEB监控的配置处理
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*"); // 进行druid监控的配置处理操作
        servletRegistrationBean.addInitParameter("allow",
                "127.0.0.1,192.168.1.159"); // 白名单
        servletRegistrationBean.addInitParameter("deny", "192.168.1.200");  // 黑名单
        servletRegistrationBean.addInitParameter("loginUsername", "root");  // 用户名
        servletRegistrationBean.addInitParameter("loginPassword", "sj2802");// 密码
        servletRegistrationBean.addInitParameter("resetEnable", "false");   // 是否可以重置数据源
        return servletRegistrationBean ;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;
        filterRegistrationBean.setFilter(new WebStatFilter());

        filterRegistrationBean.addUrlPatterns("/*");    // 所有请求进行监控处理
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return filterRegistrationBean ;
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }




}