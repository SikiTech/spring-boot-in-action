/**
 * projectName: spring-boot-in-action
 * fileName: LearnResouce.java
 * packageName: com.sikiapp.springbootinaction.thymeleaf
 * date: 2019-05-14 下午9:23
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.thymeleaf;

import lombok.Data;

/**
 * @className: LearnResouce
 * @packageName: com.sikiapp.springbootinaction.thymeleaf
 * @description: 学习资源
 * @author: Robert
 * @data: 2019-05-14 下午9:23
 * @version: V1.0
 **/
@Data
public class LearnResouce {

    private String author;
    private String title;
    private String url;

    public LearnResouce(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }
}