package me.xiaotian.ichat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by guoxiaotian on 2017/5/4.
 */

@Document(collection = "friendMsg")
public class AddFriendMsg implements Serializable{

    @Id
    private String id;

    private String srcId;
    private String desId;
    private String status;

    public AddFriendMsg() {
    }

    public AddFriendMsg(String id, String srcId, String desId, String status) {
        this.id = id;
        this.srcId = srcId;
        this.desId = desId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    public String getDesId() {
        return desId;
    }

    public void setDesId(String desId) {
        this.desId = desId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
