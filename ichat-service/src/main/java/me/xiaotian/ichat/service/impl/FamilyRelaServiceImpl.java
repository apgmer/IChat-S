package me.xiaotian.ichat.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import me.xiaotian.ichat.entity.FamilyInfos;
import me.xiaotian.ichat.entity.FamilyRelaEntity;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.repository.FamilyRelaRepository;
import me.xiaotian.ichat.service.FamilyRelaService;
import me.xiaotian.ichat.service.FamilyUserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@Service
@org.springframework.stereotype.Service
public class FamilyRelaServiceImpl implements FamilyRelaService {

    @Resource
    private FamilyRelaRepository familyRelaRepository;

    @Resource
    private FamilyUserService familyUserService;


    public FamilyRelaEntity findOne(String id) {
        return familyRelaRepository.findOne(id);
    }


    @Transactional
    public boolean addMem(String familyid, FamilyUserEntity familyUserEntity) {


        familyUserEntity.setFamilyId(familyid);
        FamilyUserEntity dbu = familyUserService.directSaveNoFamily(familyUserEntity);

        FamilyRelaEntity familyRelaEntity = familyRelaRepository.findOne(familyid);
        Set<String> mems = familyRelaEntity.getMems();
        mems.add(dbu.getId());
        familyRelaEntity.setMems(mems);
        FamilyRelaEntity t = familyRelaRepository.save(familyRelaEntity);

        familyUserEntity.setFamilyId(t.getId());
        if (null != t && dbu != null) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean delMem(String familyId, String memId) {
        FamilyRelaEntity familyRelaEntity = familyRelaRepository.findOne(familyId);
        Set<String> mems = familyRelaEntity.getMems();
        mems.remove(memId);
        familyRelaEntity.setMems(mems);

        if (null != familyRelaRepository.save(familyRelaEntity)){
            if (familyUserService.delOne(memId)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean addFamily(FamilyRelaEntity familyRelaEntity) {
        if (null != familyRelaRepository.save(familyRelaEntity)) {
            return true;
        } else {
            return false;
        }
    }

    public FamilyInfos getAllInfoById(String id) {
        FamilyInfos familyInfos = new FamilyInfos();
        FamilyRelaEntity fre = familyRelaRepository.findOne(id);
        Set<FamilyUserEntity> fus = new HashSet<FamilyUserEntity>();
        for (String uid:fre.getMems()){
            FamilyUserEntity fu = familyUserService.findById(uid);
            fus.add(fu);
        }
        familyInfos.setId(fre.getId());
        familyInfos.setMems(fus);
        return familyInfos;
    }
}
