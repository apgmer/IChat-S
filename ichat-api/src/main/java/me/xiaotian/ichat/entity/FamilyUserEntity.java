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
    private String name;
    private String pass;

    public FamilyUserEntity() {
    }

    public FamilyUserEntity(String id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
