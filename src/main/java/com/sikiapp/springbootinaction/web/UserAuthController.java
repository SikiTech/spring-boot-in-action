/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-07 下午11:20
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.mapper.test1.UserAuth1Mapper;
import com.sikiapp.springbootinaction.mapper.test2.UserAuth2Mapper;
import com.sikiapp.springbootinaction.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: UserAuthController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description:
 * @author: Robert
 * @data: 2019-05-07 下午11:20
 * @version: V1.0
 **/
@Controller
@RequestMapping("/userAuth")
public class UserAuthController {

    private UserAuth1Mapper userAuth1Mapper;
    private UserAuth2Mapper userAuth2Mapper;

    @Autowired
    public UserAuthController(UserAuth1Mapper userAuth1Mapper, UserAuth2Mapper userAuth2Mapper) {
        this.userAuth1Mapper = userAuth1Mapper;
        this.userAuth2Mapper = userAuth2Mapper;
    }

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByIdentifier1() throws Exception {
        UserAuth userAuth = userAuth1Mapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        return userAuth;
    }

    @RequestMapping(value = "/4", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByIdentifier2() throws Exception {
        UserAuth userAuth = userAuth2Mapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        return userAuth;
    }




}