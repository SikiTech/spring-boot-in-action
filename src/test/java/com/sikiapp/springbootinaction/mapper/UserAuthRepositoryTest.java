package com.sikiapp.springbootinaction.mapper;

import com.sikiapp.springbootinaction.model.UserAuth;
import com.sikiapp.springbootinaction.repository.UserAuthRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAuthRepositoryTest {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Test
    public void testPageQuery() throws Exception {
        Optional<UserAuth> auth = userAuthRepository.findById(36100);
//        System.out.println(auth);

        // 分页控制
        int page=1, size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<UserAuth> all = userAuthRepository.findAll(pageable);
        System.out.println(all);
    }

    @Test
    public void findByIdentifier() {
        UserAuth userAuth = userAuthRepository.findByIdentifier("15521291337");
        System.out.println(userAuth);
    }

    @Test
    public void findByIdentifierAndCertificate() {
        UserAuth auth = userAuthRepository.findByIdentifierAndCertificate("15521291337", "caicx621");
        System.out.println(auth);
    }




}