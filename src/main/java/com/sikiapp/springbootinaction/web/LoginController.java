/**
 * projectName: spring-boot-in-action
 * fileName: LoginController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-27 下午2:27
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @className: LoginController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 登录认真
 * @author: Robert
 * @data: 2019-05-27 下午2:27
 * @version: V1.0
 **/
@RestController
//@RequestMapping("/auths")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/hello")
    public String hello() {
        logger.info("不登录也可以访问...");
        return "hello...";
    }

    @GetMapping(value = "/index")
    public String index() {
        logger.info("登陆成功了...");
        return "index";
    }

    @GetMapping(value = "/denied")
    public String denied() {
        logger.info("小伙子权限不足,别无谓挣扎了...");
        return "denied...";
    }

    @GetMapping(value = "/login")
    public String login(String username, String password, RedirectAttributes model) {
        // 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟 shiro 的拦截地址内．不然后会报空指针
        Subject sub = SecurityUtils.getSubject();
        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
        // 认证执行者交由自定义的AuthRealm 中 doGetAuthenticationInfo 处理
        // 当以上认证成功后会向下执行,认证失败会抛出异常
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            sub.login(token);
        } catch (UnknownAccountException e) {
            logger.error("对用户[{}]进行登录验证,验证未通过,用户不存在", username);
            token.clear();
            return "UnknownAccountException";
        } catch (LockedAccountException lae) {
            logger.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", username);
            token.clear();
            return "LockedAccountException";
        } catch (ExcessiveAttemptsException e) {
            logger.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", username);
            token.clear();
            return "ExcessiveAttemptsException";
        } catch (AuthenticationException e) {
            logger.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", username, e);
            token.clear();
            return "AuthenticationException";
        }
        return "success";
    }





}