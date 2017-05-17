package me.xiaotian.ichat.entity;

import java.io.Serializable;

/**
 * Created by guoxiaotian on 2017/5/18.
 */
public class FamilyUserWithStatus implements Serializable{

    private FamilyUserEntity familyUserEntity;
    private String status;

    public FamilyUserWithStatus() {
    }

    public FamilyUserWithStatus(FamilyUserEntity familyUserEntity, String status) {
        this.familyUserEntity = familyUserEntity;
        this.status = status;
    }

    public FamilyUserEntity getFamilyUserEntity() {
        return familyUserEntity;
    }

    public void setFamilyUserEntity(FamilyUserEntity familyUserEntity) {
        this.familyUserEntity = familyUserEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
