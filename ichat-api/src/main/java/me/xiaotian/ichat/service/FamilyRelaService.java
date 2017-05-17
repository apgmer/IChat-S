package me.xiaotian.ichat.service;

import me.xiaotian.ichat.entity.FamilyInfos;
import me.xiaotian.ichat.entity.FamilyRelaEntity;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.entity.FamilyUserWithStatus;

import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/16.
 */
public interface FamilyRelaService {

    /**
     * 查询一个
     *
     * @param id
     * @return
     */
    FamilyRelaEntity findOne(String id);

    /**
     * 添加成员
     * @param familyid
     * @param familyUserEntity
     * @return
     */
    boolean addMem(String familyid, FamilyUserEntity familyUserEntity);

    /**
     * 删除成员
     * @param familyId
     * @param memId
     * @return
     */
    boolean delMem(String familyId, String memId);

    /**
     * 新建家庭
     * @param familyRelaEntity
     * @return
     */
    boolean addFamily(FamilyRelaEntity familyRelaEntity);

    /**
     * 单个家庭所有信息
     * @param id
     * @return
     */
    FamilyInfos getAllInfoById(String id);

    /**
     * 获取单个家庭的用户在线信息
     * @param fid
     * @return
     */
    Set<FamilyUserWithStatus> getUserAndStatusByFamily(String fid);

}
