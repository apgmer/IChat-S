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

    public FamilyUserEntity() {
    }

    public FamilyUserEntity(String id, String phone, String pass, String familyId) {
        this.id = id;
        this.phone = phone;
        this.pass = pass;
        this.familyId = familyId;
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
}
