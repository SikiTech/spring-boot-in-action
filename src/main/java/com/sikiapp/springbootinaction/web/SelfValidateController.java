/**
 * projectName: spring-boot-in-action
 * fileName: SelfValidateController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-25 下午3:46
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.annotation.DateTime;
import com.sikiapp.springbootinaction.annotation.Groups;
import com.sikiapp.springbootinaction.model.Electronics;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: SelfValidateController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 参数校验
 * @author: Robert
 * @data: 2019-05-25 下午3:46
 * @version: V1.0
 **/
@Validated
@RestController
@RequestMapping("/self/validators")
public class SelfValidateController {

    @GetMapping("/test")
    public String tets(@DateTime(message = "您输入的格式错误，正确的格式为：{format}", format = "yyyy-MM-dd HH:mm") String date) {
        return "success";
    }

    @GetMapping("/insert")
    @ResponseBody
    public String insert(@Validated(value = Groups.Default.class) Electronics electronics) {
        return "insert";
    }

    @GetMapping("/update")
    @ResponseBody
    public String update(@Validated(value = {Groups.Default.class, Groups.Update.class}) Electronics electronics) {
        return "update";
    }



}