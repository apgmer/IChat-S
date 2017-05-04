package me.xiaotian.ichat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Document(collection = "user")
public class UserEntity implements Serializable{

    @Id
    private String id;

    private String name;
    private String pass;
    private List<String> friends;

    public UserEntity(){

    }

    public UserEntity(String id, String name, String pass, List<String> friends) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.friends = friends;
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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", friends=" + friends +
                '}';
    }
}
