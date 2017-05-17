package me.xiaotian.ichat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/16.
 */
@Document(collection = "familyRela")
public class FamilyRelaEntity implements Serializable {

    @Id
    private String id;
    private Set<String> mems;

    public FamilyRelaEntity(String id, Set<String> mems) {
        this.id = id;
        this.mems = mems;
    }

    public FamilyRelaEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getMems() {
        return mems;
    }

    public void setMems(Set<String> mems) {
        this.mems = mems;
    }
}
