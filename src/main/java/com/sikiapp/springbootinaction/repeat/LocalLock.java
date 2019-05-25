/**
 * projectName: spring-boot-in-action
 * fileName: LocalLock.java
 * packageName: com.sikiapp.springbootinaction.repeat
 * date: 2019-05-25 下午6:08
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repeat;

import java.lang.annotation.*;

/**
 * @className: LocalLock
 * @packageName: com.sikiapp.springbootinaction.repeat
 * @description: Lock注解
 * @author: Robert
 * @data: 2019-05-25 下午6:08
 * @version: V1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    // token
    String key() default "";

    // Guava不需要这属性，继承Redis需要
    int expire() default 5;
}