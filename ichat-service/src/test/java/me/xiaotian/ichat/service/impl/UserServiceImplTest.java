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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/spring-dao.xml"})
public class UserServiceImplTest extends TestCase {


    @Resource
    private RedisService redisService;

    @Resource
    private UserService userService;

    @Test
    public void userLogin() throws Exception {
        UserEntity userEntity = userService.userLogin("name", "xxx");
        System.out.println(userEntity);
    }

    @Test
    public void saveOne() throws Exception {

        UserEntity userEntity = new UserEntity();
        userEntity.setName("name123");
        userEntity.setPass("pass");
        userEntity.setFriends(null);
        Object obj = userService.saveOne(userEntity);
        System.out.println(obj);
    }


    @Test
    public void testQueryAllUser() throws Exception {
        List<UserEntity> users = userService.queryAllUser();
        System.out.println(users);
    }

    @Test
    public void testRedis() throws Exception {
        UserEntity userEntity = userService.userLogin("name","xxx");
        List<String> friedns = new ArrayList<String>();
        friedns.add("xxxsdfa;sldjf;lkasjdf;kjas;df");
        userEntity.setFriends(friedns);
        for(int i = 0 ; i < 100 ; i ++){
            redisService.set(userEntity.getId()+i,toJson(userEntity));
        }
    }

    private String toJson(Object object) throws IOException {
        return new ObjectMapper().writeValueAsString(object);
    }
    @Test
    public void testRedisRead() throws Exception{
        boolean is = redisService.exists("590a956725ac948c2ea6c6fb15");
        System.out.println(is);

//        long i = redisService.delete("590a956725ac948c2ea6c6fb15");
//        System.out.println(i);
    }

}