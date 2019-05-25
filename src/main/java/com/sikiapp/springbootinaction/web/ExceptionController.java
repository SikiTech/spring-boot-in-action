/**
 * projectName: spring-boot-in-action
 * fileName: ExceptionController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-25 上午3:59
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.Exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ExceptionController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 异常
 * @author: Robert
 * @data: 2019-05-25 上午3:59
 * @version: V1.0
 **/
@RestController
public class ExceptionController {

    @GetMapping("/test3")
    public String test3(Integer num) {
        // 演示需要，实际上参数是否为空通过 @RequestParam(required = true)  就可以控制
        if (num == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), "num不能为空");
        }
        int i = 10 / num;
        return "result:" + i;
    }
}