package me.xiaotian.ichat.service;

import me.xiaotian.ichat.entity.UserEntity;

import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public interface UserService {

    UserEntity login(String name, String pass);

    List<UserEntity> queryAllUser();

    UserEntity register(UserEntity userEntity);

}
