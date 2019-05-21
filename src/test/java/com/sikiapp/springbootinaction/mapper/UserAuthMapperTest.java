package com.sikiapp.springbootinaction.mapper;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sikiapp.springbootinaction.model.UserAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAuthMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthMapperTest.class);

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Test
    public void test() throws Exception {

        // lambda写法
        PageInfo<Object> aus = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> userAuthMapper.selectAll());
        System.out.println(aus);

        // 普通写法
        PageHelper.startPage(1, 10).setOrderBy("id desc");
        PageInfo<UserAuth> userPageInfo = new PageInfo<>(this.userAuthMapper.selectAll());
        System.out.println(userPageInfo);
    }

}