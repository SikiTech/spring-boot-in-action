/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-07 下午11:20
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sikiapp.springbootinaction.mapper.UserAuthMapper;
import com.sikiapp.springbootinaction.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    private UserAuthMapper userAuthMapper;

    @Autowired
    public UserAuthController(UserAuthMapper userAuthMapper) {
        this.userAuthMapper = userAuthMapper;
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByIdentifier() throws Exception {
        UserAuth userAuth = userAuthMapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        return userAuth;
    }

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByIdentifier1() throws Exception {
        UserAuth userAuth = userAuthMapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        return userAuth;
    }

    @RequestMapping(value = "/4", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByIdentifier2() throws Exception {
        UserAuth userAuth = userAuthMapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        return userAuth;
    }

    @RequestMapping(value = "/5", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByPrimaryKey() throws Exception {
        UserAuth userAuth = userAuthMapper.selectByPrimaryKey(36258);
        return userAuth;
    }

    @RequestMapping(value = "/6", method = RequestMethod.GET)
    @ResponseBody
    public List<UserAuth> selectByUserBaseId() throws Exception {
        List<UserAuth> auths = userAuthMapper.selectByUserBaseId(1196);
        return auths;
    }

    @RequestMapping(value = "/7", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<UserAuth> pageSelect() throws Exception {
        PageHelper.startPage(1, 10).setOrderBy("id desc");
        PageInfo<UserAuth> userPageInfo = new PageInfo<>(this.userAuthMapper.selectAll());
        return userPageInfo;
    }





}