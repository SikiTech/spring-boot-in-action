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
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}