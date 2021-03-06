/**
 * projectName: spring-boot-in-action
 * fileName: MyProperties1.java
 * packageName: com.sikiapp.springbootinaction.properties
 * date: 2019-05-14 下午3:19
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @className: MyProperties1
 * @packageName: com.sikiapp.springbootinaction.properties
 * @description:
 * @author: Robert
 * @data: 2019-05-14 下午3:19
 * @version: V1.0
 **/
@Data
@Component
@PropertySource("classpath:my2.properties")
@ConfigurationProperties(prefix = "my2")
public class MyProperties2 {

    private int age;
    private String name;
    private String email;
}