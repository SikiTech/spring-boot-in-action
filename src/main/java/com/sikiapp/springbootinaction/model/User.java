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

    private static final long serialVersionUID = -6701849832999063005L;

    private Long id;
    private String username;
    private String password;
    private String roleName;
    private Boolean locked;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String username, String sex, Integer age) {
        this.username = username;
        this.sex = sex;
        this.age = age;
    }

    public User(Long id, String username, String password, String roleName, Boolean locked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.locked = locked;
    }
}