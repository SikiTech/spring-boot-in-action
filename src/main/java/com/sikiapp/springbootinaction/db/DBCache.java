/**
 * projectName: spring-boot-in-action
 * fileName: DBCache.java
 * packageName: com.sikiapp.springbootinaction.db
 * date: 2019-05-27 上午11:31
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.db;

import com.sikiapp.springbootinaction.model.User;

import java.util.*;

/**
 * @className: DBCache
 * @packageName: com.sikiapp.springbootinaction.db
 * @description: 数据库缓存 （模拟测试）
 * @author: Robert
 * @data: 2019-05-27 上午11:31
 * @version: V1.0
 **/
public class DBCache {

    /**
     * K 用户ID
     * V 用户信息
     */
    public static final Map<String, User> USERS_CACHE = new HashMap<>();

    /**
     * K 角色ID
     * V 角色权限
     */
    public static final Map<String, Collection<String>> PERMISSIONS_CACHE = new HashMap<>();

    static {
        USERS_CACHE.put("u1", new User(1L, "u1", "p1", "admin", false));
        USERS_CACHE.put("u2", new User(2L, "u2", "p2", "admin", false));
        USERS_CACHE.put("u3", new User(3L, "u3", "p3", "test", true));

        PERMISSIONS_CACHE.put("admin", Arrays.asList("user:list", "user:add", "user:edit"));
        PERMISSIONS_CACHE.put("test", Collections.singletonList("user:list"));
    }
}