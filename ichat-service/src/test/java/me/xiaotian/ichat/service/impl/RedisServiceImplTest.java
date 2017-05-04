package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by guoxiaotian on 2017/5/4.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/spring-dao.xml"})
public class RedisServiceImplTest {

    @Resource
    private RedisService redisService;

    @Test
    public void getAllKeys() throws Exception {

        List<String> keys = redisService.getAllKeys();
        System.out.println(keys);

    }

    @Test
    public void clearRedis() throws Exception{
        redisService.flushDB();
    }

}