/**
 * projectName: spring-boot-in-action
 * fileName: SpringTaskHandler.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-24 上午10:39
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @className: SpringTaskHandler
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: Spring Task 定时任务
 * @author: Robert
 * @data: 2019-05-24 上午10:39
 * @version: V1.0
 **/
@Component
public class SpringTaskHandler {

    private static final Logger logger = LoggerFactory.getLogger(SpringTaskHandler.class);

    @Scheduled(cron = "*/1 * * * * *")
    public void scheduile1() throws Exception {
        Thread.sleep(3000);
        logger.info("同步 每秒执行一次：{}", LocalDateTime.now());
    }

    @Async
    @Scheduled(cron = "*/1 * * * * *")
    public void scheduile2() throws Exception {
        Thread.sleep(3000);
        logger.info("异步 每秒执行一次：{}", LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1000)
    public void scheduile3() throws Exception {
        Thread.sleep(3000);
        logger.info("固定周期 每秒执行一次：{}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduile4() throws Exception {
        Thread.sleep(3000);
        logger.info("固定延迟 每秒执行一次：{}", LocalDateTime.now());
    }








}