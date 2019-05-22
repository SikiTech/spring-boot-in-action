/**
 * projectName: spring-boot-in-action
 * fileName: PropertiesController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-14 下午3:37
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.properties.MyProperties1;
import com.sikiapp.springbootinaction.properties.MyProperties2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: PropertiesController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 属性配置
 * @author: Robert
 * @data: 2019-05-14 下午3:37
 * @version: V1.0
 **/
@Api(value = "Properties Controller", description = "通过配置类读取properties文件", tags = "PropertiesController")
@RequestMapping("/properties")
@RestController
public class PropertiesController {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesController.class);
    private final MyProperties1 properties1;
    private final MyProperties2 properties2;

    @Autowired
    public PropertiesController(MyProperties1 properties1, MyProperties2 properties2) {
        this.properties1 = properties1;
        this.properties2 = properties2;
    }

    @ApiOperation("读取properties文件")
    @GetMapping("/1")
    public MyProperties1 myProperties1() {
        return properties1;
    }

    @GetMapping("/2")
    public MyProperties2 myProperties2() {
        return properties2;
    }
}