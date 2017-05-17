package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.service.FamilyUserService;
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
public class FamilyUserServiceImplTest {

    @Resource
    private FamilyUserService familyUserService;

    @Test
    public void sendRegCode() throws Exception {
        boolean f = familyUserService.sendRegCode("17000107276");
        System.out.println(f);
    }

    @Test
    public void directSaveOne() throws Exception {

        FamilyUserEntity u = new FamilyUserEntity();
        u.setPass("123");
        u.setNickname("asdf");
        u.setPhone("123123");
        u.setRole("123123123");

        familyUserService.directSaveOne(u);
    }


}