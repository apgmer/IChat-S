package me.xiaotian.ichat.service;

import me.xiaotian.ichat.entity.FamilyUserEntity;

/**
 * Created by guoxiaotian on 2017/5/16.
 */
public interface FamilyUserService {

    /**
     * 注册
     *
     * @param user
     * @param regCode
     * @return
     */
    boolean reg(FamilyUserEntity user, String regCode);

    /**
     * 发送注册验证码
     *
     * @param phone
     * @return
     */
    boolean sendRegCode(String phone);

    /**
     * 查找单个
     *
     * @param phone
     * @return
     */
    FamilyUserEntity findByPhone(String phone);

    /**
     * find by id
     * @param id
     * @return
     */
    FamilyUserEntity findById(String id);

    /**
     * 登录
     *
     * @param familyUserEntity
     * @return
     */
    FamilyUserEntity login(FamilyUserEntity familyUserEntity);

    /**
     * 直接保存 新建家庭
     * @param familyUserEntity
     * @return
     */
    boolean directSaveOne(FamilyUserEntity familyUserEntity);

    /**
     * 直接保存 不新建家庭
     * @param familyUserEntity
     * @return
     */
    FamilyUserEntity directSaveNoFamily(FamilyUserEntity familyUserEntity);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delOne(String id);

    /**
     * 保持用户在线
     * @param uid
     * @return
     */
    boolean keepOnline(String uid);
}
