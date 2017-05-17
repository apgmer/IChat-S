package me.xiaotian.ichat.repository;

import me.xiaotian.ichat.common.FAMILYROLE;
import me.xiaotian.ichat.entity.FamilyRelaEntity;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.service.FamilyRelaService;
import me.xiaotian.ichat.service.FamilyUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/spring-dao.xml"})
public class FamilyUserRepositoryTest {

    @Resource
    private FamilyUserRepository familyUserRepository;

    @Resource
    private FamilyRelaRepository familyRelaRepository;

    @Test
    public void testMongo() throws Exception{
        FamilyUserEntity familyUserEntity = new FamilyUserEntity();
        familyUserEntity.setPhone("1234");
        familyUserEntity.setPass("456789");
        familyUserEntity.setNickname("儿子");
        familyUserEntity.setRole(FAMILYROLE.SON);
        familyUserRepository.save(familyUserEntity);
    }

    @Test
    public void testMogo2() throws Exception{
        FamilyRelaEntity familyRelaEntity = new FamilyRelaEntity();
        Set<String> s = new HashSet<String>();
        s.add("591b9f8025ac35fb7884394d");
        familyRelaEntity.setMems(s);
        familyRelaRepository.save(familyRelaEntity);
    }

    @Test
    public void getRela() throws Exception{
        FamilyRelaEntity f = familyRelaRepository.findOne("591b0fc125ac53e2ff135941");
        System.out.println(f);
    }

    @Test
    public void delTest() throws Exception{
        familyUserRepository.delete("591b9f8025ac35fb7884394d");
    }

}