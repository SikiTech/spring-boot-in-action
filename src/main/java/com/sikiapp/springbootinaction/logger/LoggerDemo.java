/**
 * projectName: spring-boot-in-action
 * fileName: LoggerDemo.java
 * packageName: com.sikiapp.springbootinaction.logger
 * date: 2019-05-14 下午8:23
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @className: LoggerDemo
 * @packageName: com.sikiapp.springbootinaction.logger
 * @description:
 * @author: Robert
 * @data: 2019-05-14 下午8:23
 * @version: V1.0
 **/
@Component
public class LoggerDemo {

    private static final Logger logger = LoggerFactory.getLogger(LoggerDemo.class);

    public LoggerDemo() {
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
    }
}