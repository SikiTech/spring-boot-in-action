/**
 * projectName: spring-boot-in-action
 * fileName: BookController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-23 上午11:49
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.config.RabbitConfig;
import com.sikiapp.springbootinaction.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: BookController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: Book Controller 生产者
 * @author: Robert
 * @data: 2019-05-23 上午11:49
 * @version: V1.0
 **/
@RestController
@RequestMapping(value = "/books")
public class BookProduceController {

    private static final Logger logger = LoggerFactory.getLogger(BookProduceController.class);

    private final RabbitTemplate rabbitTemplate;
    private AtomicInteger ai = new AtomicInteger(1);

    @Autowired
    public BookProduceController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/p")
    public void produceMessage() {
        Book book = new Book();
        book.setId(ai.getAndAdd(1));
        book.setName("RabbitMQ opts");
        this.rabbitTemplate.convertAndSend(RabbitConfig.DEFAULT_BOOK_QUEUE, book);
        this.rabbitTemplate.convertAndSend(RabbitConfig.MANUAL_BOOK_QUEUE, book);
    }

    @GetMapping("/d")
    public void defaultMessage() {
        Book book = new Book();
        book.setId(ai.getAndAdd(1));
        book.setName("一起来学Spring Boot");
        // 添加延时队列
        this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book, message -> {
            // 第一句是可要可不要,根据自己需要自行处理
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
            // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(5 * 1000 + "");
            return message;
        });
        logger.info("[发送时间] - [{}]", LocalDateTime.now());
    }


}