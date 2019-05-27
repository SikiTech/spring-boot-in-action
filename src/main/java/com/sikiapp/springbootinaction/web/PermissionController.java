/**
 * projectName: spring-boot-in-action
 * fileName: PermissionController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-27 下午2:44
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: PermissionController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 授权控制
 * @author: Robert
 * @data: 2019-05-27 下午2:44
 * @version: V1.0
 **/
@RestController
@RequestMapping("roles")
public class PermissionController {

    @GetMapping
    public String get() {
        return "get.....";
    }

    /**
     * RequiresRoles 是所需角色 包含 AND 和 OR 两种
     * RequiresPermissions 是所需权限 包含 AND 和 OR 两种
     * @return msg
     */
    @RequiresRoles(value = {"admin", "test"}, logical = Logical.OR)
    @RequiresPermissions(value = {"user:list", "user:query"}, logical = Logical.OR)
    @GetMapping("/query")
    public String query() {
        return "query.....";
    }

    @GetMapping("/find")
    public String find() {
        return "find.....";
    }

}