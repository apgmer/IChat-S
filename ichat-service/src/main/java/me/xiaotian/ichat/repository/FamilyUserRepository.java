package me.xiaotian.ichat.repository;

import me.xiaotian.ichat.entity.FamilyUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by guoxiaotian on 2017/5/16.
 */
public interface FamilyUserRepository extends MongoRepository<FamilyUserEntity, String> {

}
