/**
 * projectName: spring-boot-in-action
 * fileName: MyHealthIndicator.java
 * packageName: com.sikiapp.springbootinaction.service
 * date: 2019-05-23 下午6:19
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.service;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 * @className: MyHealthIndicator
 * @packageName: com.sikiapp.springbootinaction.service
 * @description: 装配 HealthIndicators
 * @author: Robert
 * @data: 2019-05-23 下午6:19
 * @version: V1.0
 **/
public class MyHealthIndicator extends AbstractHealthIndicator {

    private static final String VERSION = "v1.0.0";

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int code = check();
        if (code != 0) {
            builder.down().withDetail("code", code)
                    .withDetail("version", VERSION).build();
        }
        builder.withDetail("code", code).withDetail("version", VERSION).up().build();
    }

    private int check() {
        return 0;
    }
}