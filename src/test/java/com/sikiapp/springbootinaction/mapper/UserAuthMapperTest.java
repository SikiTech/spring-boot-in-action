package com.sikiapp.springbootinaction.mapper;

import com.sikiapp.springbootinaction.model.UserAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.sikiapp.springbootinaction.mapper")
public class UserAuthMapperTest {

    @Autowired
    private UserAuthMapper userAuthMapper;

    //
    @Test
    public void getOne() {
        UserAuth auth = userAuthMapper.getOne(36258);
        System.out.println(auth);
    }

    @Test
    public void selectByIdentifier() throws Exception {
        UserAuth userAuth = userAuthMapper.selectByIdentifier("15521291337", "caicx621", (byte)1);
        System.out.println(userAuth);
    }



}