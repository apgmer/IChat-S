package me.xiaotian.ichat.service;

import me.xiaotian.ichat.entity.FamilyUserEntity;

/**
 * Created by guoxiaotian on 2017/5/16.
 */
public interface FamilyUserService {

    boolean reg(FamilyUserEntity user, String regCode);

    boolean sendRegCode(String phone);

    FamilyUserEntity findByPhone(String phone);


}
