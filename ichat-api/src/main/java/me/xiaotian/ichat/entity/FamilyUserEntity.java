package me.xiaotian.ichat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@Document(collection = "familyUser")
public class FamilyUserEntity implements Serializable {

    @Id
    private String id;
    private String phone;
    private String pass;
    private String familyId;
    private String role;
    private String nickname;

    public FamilyUserEntity() {
    }

    public FamilyUserEntity(String id, String phone, String pass, String familyId, String role, String nickname) {
        this.id = id;
        this.phone = phone;
        this.pass = pass;
        this.familyId = familyId;
        this.role = role;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
