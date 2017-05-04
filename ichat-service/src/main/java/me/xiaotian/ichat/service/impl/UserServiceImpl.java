package me.xiaotian.ichat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.repository.UserRepository;
import me.xiaotian.ichat.service.RedisService;
import me.xiaotian.ichat.service.UserService;
import me.xiaotian.util.PasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


/**
 * Created by guoxiaotian on 2017/5/4.
 */

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    @Resource
    private RedisService redisService;

    public UserEntity login(String name, String pass) {
        UserEntity u = userRepository.findByName(name);
        if (PasswordUtil.isEqual(pass,u.getPass())){
            if (saveUserToRedis(u)){
                return u;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public UserEntity getUserById(String id){
        return userRepository.findOne(id);
    }

    public List<UserEntity> queryAllUser() {
        return userRepository.findAll();
    }

    public UserEntity register(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    private boolean saveUserToRedis(UserEntity u){
        try {
            return redisService.set(u.getId(),toJson(u),300);
        } catch (IOException e) {
            redisService.delete(u.getId());
            e.printStackTrace();
            return false;
        }
    }

    private String toJson(Object object) throws IOException {
        return new ObjectMapper().writeValueAsString(object);
    }


}
