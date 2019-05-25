/**
 * projectName: spring-boot-in-action
 * fileName: LockMethodInterceptor.java
 * packageName: com.sikiapp.springbootinaction.repeat
 * date: 2019-05-25 下午6:17
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repeat;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sikiapp.springbootinaction.Exception.CustomException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @className: LockMethodInterceptor
 * @packageName: com.sikiapp.springbootinaction.repeat
 * @description: 基于本地缓存的Lock 拦截器
 * @author: Robert
 * @data: 2019-05-25 下午6:17
 * @version: V1.0
 **/
@Aspect
@Configuration
public class LockMethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LockMethodInterceptor.class);

    private static final Cache<String, Object> CACHES = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    @Around("execution(public * *(..)) && @annotation(com.sikiapp.springbootinaction.repeat.LocalLock)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = generateKey(localLock.key(), pjp.getArgs());
        logger.info(pjp.getArgs().toString());
        logger.info(key);
        if (!StringUtils.isEmpty(key)) {
            if (CACHES.getIfPresent(key) != null) {
                throw new CustomException(HttpStatus.BAD_REQUEST.value(), "请勿重复提交");
            }

            // 如果是第一次请求,就将 key 当前对象压入缓存中
            CACHES.put(key, key);
        }

        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException("服务器异常");
        } finally {
            // TODO 如果演示的话需要注释该代码;实际应该放开
            CACHES.invalidate(key);
        }
    }

    /**
     *@description: key 的生成策略
     * 如果想灵活可以写成接口与实现类的方式
     */
    private String generateKey(String keyExpress, Object[] args) {
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
        }

        return keyExpress;
    }

}