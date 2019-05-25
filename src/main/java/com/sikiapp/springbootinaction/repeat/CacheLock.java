/**
 * projectName: spring-boot-in-action
 * fileName: CacheLock.java
 * packageName: com.sikiapp.springbootinaction.repeat
 * date: 2019-05-25 下午9:38
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repeat;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @className: CacheLock
 * @packageName: com.sikiapp.springbootinaction.repeat
 * @description: Redis 锁
 * @author: Robert
 * @data: 2019-05-25 下午9:38
 * @version: V1.0
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {

    /**
     * Redis 锁前缀
     * */
    String prefix() default "";

    /**
     * 超时时间
     * */
    int expire() default 5000;

    /**
     * 超时时间单位
     * */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * key 分隔符：
     * */
    String delimiter() default ":";
}