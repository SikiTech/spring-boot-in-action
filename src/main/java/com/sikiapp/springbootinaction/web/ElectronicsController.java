/**
 * projectName: spring-boot-in-action
 * fileName: ElectronicsController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-25 上午11:30
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.model.Electronics;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @className: ElectronicsController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 数据校验，正常放Service层
 * @author: Robert
 * @data: 2019-05-25 上午11:30
 * @version: V1.0
 **/
@Validated
@Controller
@RequestMapping(("/validators"))
public class ElectronicsController {

    @GetMapping("/test1")
    @ResponseBody
    public String test1(@NotBlank(message = "name 不能为空")
                            @Length(min = 2, max = 10, message = "name 必须在{min} - {max}之间") String name) {
        return "success";
    }

    @PostMapping("/test2")
    @ResponseBody
    public String test2(@RequestBody @Validated @NotNull Electronics electronics) {
        return "success";
    }


}