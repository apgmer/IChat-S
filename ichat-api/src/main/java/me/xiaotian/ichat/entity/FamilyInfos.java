package me.xiaotian.ichat.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/17.
 */
public class FamilyInfos implements Serializable{

    private String id;
    Set<FamilyUserEntity> mems;

    public FamilyInfos(String id, Set<FamilyUserEntity> mems) {
        this.id = id;
        this.mems = mems;
    }

    public FamilyInfos() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<FamilyUserEntity> getMems() {
        return mems;
    }

    public void setMems(Set<FamilyUserEntity> mems) {
        this.mems = mems;
    }
}
