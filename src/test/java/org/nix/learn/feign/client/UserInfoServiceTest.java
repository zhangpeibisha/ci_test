package org.nix.learn.feign.client;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.learn.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserInfoServiceTest {

    @Resource
    private UserInfoService userInfoService;

    @Test
    public void test(){
        JSONObject userInfo = userInfoService.findUserInfo();
        System.out.println(userInfo);
    }

}