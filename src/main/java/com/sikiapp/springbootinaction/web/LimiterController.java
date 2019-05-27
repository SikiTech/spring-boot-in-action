/**
 * projectName: spring-boot-in-action
 * fileName: LimiterController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-27 下午6:31
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.limitation.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: LimiterController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 限流控制
 * @author: Robert
 * @data: 2019-05-27 下午6:31
 * @version: V1.0
 **/
@RestController
public class LimiterController {

    private static final AtomicInteger NUM = new AtomicInteger(0);

    @Limit(key = "limi", period = 60, count = 3)
    @GetMapping("/limits")
    public int testLimit() {
        return NUM.incrementAndGet();
    }
}