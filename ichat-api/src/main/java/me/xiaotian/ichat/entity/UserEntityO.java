package me.xiaotian.ichat.entity;

import java.io.Serializable;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public class UserEntityO implements Serializable {
    private UserEntity userinfo;
    private String status;

    public UserEntityO(UserEntity userinfo, String status) {
        this.userinfo = userinfo;
        this.status = status;
    }

    public UserEntityO() {
    }

    public UserEntity getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserEntity userinfo) {
        this.userinfo = userinfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
