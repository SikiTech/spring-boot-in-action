/**
 * projectName: spring-boot-in-action
 * fileName: ThymeleafController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-14 下午9:25
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.thymeleaf.LearnResouce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * @className: ThymeleafController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: Thymeleaf Demo
 * @author: Robert
 * @data: 2019-05-14 下午9:25
 * @version: V1.0
 **/
@Controller
@RequestMapping("/learn")
public class ThymeleafController {

    @GetMapping("/")
    public ModelAndView index() {
        ArrayList<LearnResouce> resouces = new ArrayList<>();
        resouces.add(new LearnResouce("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application"));
        resouces.add(new LearnResouce("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples"));
        resouces.add(new LearnResouce("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/"));
        resouces.add(new LearnResouce("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/"));
        resouces.add(new LearnResouce("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488"));
        resouces.add(new LearnResouce("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot"));
        resouces.add(new LearnResouce("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html"));
        resouces.add(new LearnResouce("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html"));
        resouces.add(new LearnResouce("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333"));

        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList", resouces);
        return modelAndView;
    }
}