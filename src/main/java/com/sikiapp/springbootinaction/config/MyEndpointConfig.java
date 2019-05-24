/**
 * projectName: spring-boot-in-action
 * fileName: MyEndpointConfig.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-23 下午8:30
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.config;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MyEndpointConfig
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: Endpoint配置类
 * @author: Robert
 * @data: 2019-05-23 下午8:30
 * @version: V1.0
 **/
@Configuration
public class MyEndpointConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public MyEndpoint myEndpoint() {
        return new MyEndpoint();
    }
}