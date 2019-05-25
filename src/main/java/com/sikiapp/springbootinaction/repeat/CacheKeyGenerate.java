/**
 * projectName: spring-boot-in-action
 * fileName: CacheKeyGenerate.java
 * packageName: com.sikiapp.springbootinaction.repeat
 * date: 2019-05-25 下午9:49
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repeat;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @className: CacheKeyGenerate
 * @packageName: com.sikiapp.springbootinaction.repeat
 * @description: Redis 锁key 生成器
 * @author: Robert
 * @data: 2019-05-25 下午9:49
 * @version: V1.0
 **/
public interface CacheKeyGenerate {

    /**
     * 获取AOP参数，生成制定缓存key
     * */
    String getLockKey(ProceedingJoinPoint pjp);
}