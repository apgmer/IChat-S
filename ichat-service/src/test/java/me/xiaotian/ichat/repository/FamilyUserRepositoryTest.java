package me.xiaotian.ichat.repository;

import me.xiaotian.ichat.entity.FamilyRelaEntity;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.entity.MemInfo;
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
        FamilyUserEntity u = new FamilyUserEntity();
        u.setPhone("000000");
        u.setPass("123123123123123");
        familyUserRepository.save(u);
    }

    @Test
    public void testMogo2() throws Exception{
        FamilyRelaEntity fre = new FamilyRelaEntity();
        MemInfo memInfo = new MemInfo();
        memInfo.setUid("591b0eee772e802fc4f2df51");
        memInfo.setRole("妈妈");
        Set<MemInfo> ms = new HashSet<MemInfo>();
        ms.add(memInfo);
        fre.setMems(ms);
        familyRelaRepository.save(fre);
    }

    @Test
    public void getRela() throws Exception{
        FamilyRelaEntity f = familyRelaRepository.findOne("591b0fc125ac53e2ff135941");
        System.out.println(f);
    }

}