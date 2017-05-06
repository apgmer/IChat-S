package me.xiaotian.ichat.service;

import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.entity.UserEntityO;

import java.util.List;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public interface UserService {

    /**
     * 用户登陆，返回用户实体
     *
     * @param name
     * @param pass
     * @return
     */
    UserEntity login(String name, String pass);

    /**
     * 查询所有的用户
     *
     * @return
     */
    List<UserEntity> queryAllUser();


    /**
     * 用户注册
     *
     * @param userEntity
     * @return
     */
    UserEntity register(UserEntity userEntity);

    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    UserEntity getUserById(String id);

    /**
     * 搜索用户
     *
     * @param name
     * @return
     */
    Set<UserEntityO> searchByName(String name);

    /**
     * 心跳。保持用户在线
     *
     * @param uid
     * @return
     */
    boolean keepOnline(String uid);

    /**
     * 获取用户好友信息以及是否在线
     *
     * @param uid
     * @return
     */
    Set<UserEntityO> getFriendInfoByUserid(String uid);

    /**
     * 获取当前在线用户数
     *
     * @return
     */
    Long getOnlineSize();

    /**
     * 更新用户
     *
     * @param userEntity
     * @return
     */
    UserEntity updateUser(UserEntity userEntity);
}

