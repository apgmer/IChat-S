package me.xiaotian.ichat.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.repository.FamilyUserRepository;
import me.xiaotian.ichat.service.FamilyUserService;

import javax.annotation.Resource;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@Service
@org.springframework.stereotype.Service
public class FamilyUserServiceImpl implements FamilyUserService {

    @Resource
    private FamilyUserRepository familyUserRepository;

    public boolean reg(FamilyUserEntity user, String regCode) {
        return false;
    }

    public boolean sendRegCode(String phone) {
        return false;
    }

    public FamilyUserEntity findByPhone(String phone) {
        return familyUserRepository.findByPhone(phone);
    }
}
