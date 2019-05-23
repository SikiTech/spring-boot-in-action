/**
 * projectName: spring-boot-in-action
 * fileName: BookConsumeController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-23 下午12:14
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.service;

import com.rabbitmq.client.Channel;
import com.sikiapp.springbootinaction.config.RabbitConfig;
import com.sikiapp.springbootinaction.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @className: BookConsumeController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: Book 消费队列
 * @author: Robert
 * @data: 2019-05-23 下午12:14
 * @version: V1.0
 **/
@Component
public class BookConsumeController {

    private static final Logger logger = LoggerFactory.getLogger(BookConsumeController.class);


    @RabbitListener(queues = {RabbitConfig.DEFAULT_BOOK_QUEUE})
    public void listenerAutoAck(Book book, Message message, Channel channel) {
        // 如果手动ACK,消息会被监听消费,但是消息在队列中依旧存在,如果 未配置 acknowledge-mode 默认是会在消费完毕后自动ACK掉
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            logger.info("[listenerAutoAck 监听的消息] - [{}]", book.toString());
            // 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                // 处理失败,重新压入MQ
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @RabbitListener(queues = {RabbitConfig.MANUAL_BOOK_QUEUE})
    public void listenerManualAck(Book book, Message message, Channel channel) {
        logger.info("[listenerManualAck 监听的消息] - [{}]", book.toString());
        try {
            // 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列

        }
    }

    @RabbitListener(queues = {RabbitConfig.REGISTER_QUEUE_NAME})
    public void listenerDelayQueue(Book book, Message message, Channel channel) {
        logger.info("[listenerDelayQueue 监听的消息] - [消费时间] - [{}] - [{}]", LocalDateTime.now(), book.toString());
        try {
            // 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }
    }


}