package me.xiaotian.ichat.entity;

import java.io.Serializable;

/**
 * Created by guoxiaotian on 2017/5/16.
 */
public class MemInfo implements Serializable {
    private String uid;
    private String role;

    public MemInfo() {
    }

    public MemInfo(String uid, String role) {
        this.uid = uid;
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
