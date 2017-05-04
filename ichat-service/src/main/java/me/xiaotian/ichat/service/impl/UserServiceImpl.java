package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.repository.UserRepository;
import me.xiaotian.ichat.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by guoxiaotian on 2017/5/4.
 */

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    public UserEntity userLogin(String name, String pass) {
        return userRepository.findByName(name);
    }

    public List<UserEntity> queryAllUser() {
        return userRepository.findAll();
    }

    public Object saveOne(UserEntity userEntity){
        return userRepository.save(userEntity);
    }


}
