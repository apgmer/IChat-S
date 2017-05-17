package me.xiaotian.ichat.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by guoxiaotian on 2017/5/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/spring-dao.xml"})
public class RegCodeRedisServiceImplTest {

    @Resource
    private RegCodeRedisServiceImpl regCodeRedisService;

    @Test
    public void set() throws Exception {
        regCodeRedisService.set("17000000000","qwer",-1);
    }

    @Test
    public void set1() throws Exception {
    }

    @Test
    public void set2() throws Exception {
    }

    @Test
    public void set3() throws Exception {
    }

    @Test
    public void get() throws Exception {
        String code = regCodeRedisService.get("17000000000");
        System.out.println(code);
    }

}