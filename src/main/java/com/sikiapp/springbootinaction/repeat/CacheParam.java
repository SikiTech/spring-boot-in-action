/**
 * projectName: spring-boot-in-action
 * fileName: CacheParam.java
 * packageName: com.sikiapp.springbootinaction.repeat
 * date: 2019-05-25 下午9:47
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repeat;

import java.lang.annotation.*;

/**
 * @className: CacheParam
 * @packageName: com.sikiapp.springbootinaction.repeat
 * @description: 锁的参数
 * @author: Robert
 * @data: 2019-05-25 下午9:47
 * @version: V1.0
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheParam {

    /**
     * 字段名称
     * */
    String name() default "";
}