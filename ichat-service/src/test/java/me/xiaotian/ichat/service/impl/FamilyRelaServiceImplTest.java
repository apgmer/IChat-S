package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.service.FamilyRelaService;
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
public class FamilyRelaServiceImplTest {


    @Resource
    private FamilyRelaService familyRelaService;

    @Test
    public void addMem() throws Exception {

        String fid = "591bb83825ac173e0f954652";
        FamilyUserEntity familyUserEntity = new FamilyUserEntity();
        familyUserEntity.setRole("女儿");
        familyUserEntity.setPhone("000000");
        familyUserEntity.setNickname("bbbbbbb");
        familyUserEntity.setPass("asdfasdfasdfsdaf");
        familyRelaService.addMem(fid,familyUserEntity);

    }

    @Test
    public void delMem() throws Exception {

        String fid = "591bb83825ac173e0f954652";
        familyRelaService.delMem(fid,"null");

    }

}