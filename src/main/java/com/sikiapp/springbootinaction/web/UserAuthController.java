/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-07 下午11:20
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import com.sikiapp.springbootinaction.mapper.UserAuthMapper;
import com.sikiapp.springbootinaction.repository.UserAuthRepository;
import com.sikiapp.springbootinaction.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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

    private UserAuthRepository userAuthRepository;
    private UserAuthMapper userAuthMapper;

    @Autowired
    public UserAuthController(UserAuthRepository userAuthRepository, UserAuthMapper userAuthMapper) {
        this.userAuthRepository = userAuthRepository;
        this.userAuthMapper = userAuthMapper;
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    @ResponseBody
    public String getUserAuthList() throws Exception {
        Optional<UserAuth> auth = userAuthRepository.findById(36067);
        System.out.println(auth);

        return "授权";
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    @ResponseBody
    public UserAuth selectByIdentifier() throws Exception {
        UserAuth userAuth = userAuthMapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        return userAuth;
    }


}