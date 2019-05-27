/**
 * projectName: spring-boot-in-action
 * fileName: Limit.java
 * packageName: com.sikiapp.springbootinaction.limitation
 * date: 2019-05-27 下午5:14
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.limitation;

import java.lang.annotation.*;

/**
 * @className: Limit
 * @packageName: com.sikiapp.springbootinaction.limitation
 * @description: 分布式限流
 * @author: Robert
 * @data: 2019-05-27 下午5:14
 * @version: V1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface Limit {

    /**
     * 资源的名字
     * @return String
     */
    String name() default "";

    /**
     * 资源的key
     * @return String
     */
    String key() default "";

    /**
     * Key的prefix
     * @return String
     */
    String prefix() default "";

    /**
     * 给定的时间段
     * 单位秒
     * @return int
     */
    int period();

    /**
     * 最多的访问限制次数
     * @return int
     */
    int count();

    /**
     * 类型
     *
     * @return LimitType
     */
    LimitType limitType() default LimitType.IP;

    public enum LimitType {
        /**
         * 自定义key
         */
        CUSTOMER,
        /**
         * 根据请求者IP
         */
        IP;
    }

}

