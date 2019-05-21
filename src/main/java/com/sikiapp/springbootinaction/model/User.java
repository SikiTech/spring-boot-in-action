/**
 * projectName: spring-boot-in-action
 * fileName: User.java
 * packageName: com.sikiapp.springbootinaction.model
 * date: 2019-05-21 上午8:31
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: User
 * @packageName: com.sikiapp.springbootinaction.model
 * @description: 用户
 * @author: Robert
 * @data: 2019-05-21 上午8:31
 * @version: V1.0
 **/
@Data
public class User implements Serializable {

    private String name;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}