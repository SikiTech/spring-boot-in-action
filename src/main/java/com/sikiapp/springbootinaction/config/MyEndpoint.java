/**
 * projectName: spring-boot-in-action
 * fileName: MyEndpoint.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-23 下午8:22
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: MyEndpoint
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: Actuator 自定义监控端点
 * @author: Robert
 * @data: 2019-05-23 下午8:22
 * @version: V1.0
 **/
@Endpoint(id = "sikiapp")
public class MyEndpoint {

    @ReadOperation
    public Map<String, String> hello() {
        Map<String, String> result = new HashMap<>();
        result.put("author", "Robert");
        result.put("age", "28");
        result.put("email", "robert.tsai@sikiapp.com");
        return result;
    }
}