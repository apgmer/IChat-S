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
    private Set<MemInfo> mems;

    public FamilyRelaEntity() {
    }

    public FamilyRelaEntity(String id, Set<MemInfo> mems) {
        this.id = id;
        this.mems = mems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<MemInfo> getMems() {
        return mems;
    }

    public void setMems(Set<MemInfo> mems) {
        this.mems = mems;
    }
}
