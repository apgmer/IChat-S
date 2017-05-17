package me.xiaotian.ichat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import me.xiaotian.ichat.entity.UserEntity;

import me.xiaotian.ichat.service.RedisService;
import me.xiaotian.ichat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/META-INF/spring/spring-dao.xml"})
public class UserServiceImplTest extends TestCase {


//    @Resource
//    private RedisService redisService;
//
//    @Resource
//    private UserService userService;

    @Test
    public void testc() throws Exception{
        int d = (int) (Math.random() * 9000 + 1000);
        System.out.println(d);
    }


}