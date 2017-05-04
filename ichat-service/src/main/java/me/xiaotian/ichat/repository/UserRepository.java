package me.xiaotian.ichat.repository;

import me.xiaotian.ichat.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */


public interface UserRepository extends MongoRepository<UserEntity,String> {

    UserEntity findByName(String name);

    List<UserEntity> findByNameLike(String name);

}
