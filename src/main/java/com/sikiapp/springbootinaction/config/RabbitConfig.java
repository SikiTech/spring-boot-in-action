/**
 * projectName: spring-boot-in-action
 * fileName: RabbitConfig.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-23 上午11:12
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RabbitConfig
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: RabbitMQ配置
 * @author: Robert
 * @data: 2019-05-23 上午11:12
 * @version: V1.0
 **/
@Configuration
public class RabbitConfig {

    public static final String DEFAULT_BOOK_QUEUE = "dev.book.register.default.queue";
    public static final String MANUAL_BOOK_QUEUE = "dev.book.register.manual.queue";

    @Bean
    public Queue defaultBookQueue() {
        return new Queue(DEFAULT_BOOK_QUEUE, true);
    }

    @Bean
    public Queue manualBookQueue() {
        return new Queue(MANUAL_BOOK_QUEUE, true);
    }
}