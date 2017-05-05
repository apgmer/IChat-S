package me.xiaotian.ichat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.xiaotian.ichat.common.USERSTATUS;
import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.entity.UserEntityO;
import me.xiaotian.ichat.repository.UserRepository;
import me.xiaotian.ichat.service.RedisService;
import me.xiaotian.ichat.service.UserService;
import me.xiaotian.util.PasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        if (null == u){
            return null;
        }
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

    public Set<UserEntityO> searchByName(String name){
        List<UserEntity> userlist = userRepository.findByNameLike(name);
        if (userlist.size() == 0){
            return null;
        }
        Set<UserEntityO> uos = new HashSet<UserEntityO>();
        UserEntityO uo = null;
        for (UserEntity u: userlist){
            uo = new UserEntityO();
            uo.setUserinfo(u);
            if (redisService.exists(u.getId())){
                uo.setStatus(USERSTATUS.ONLINE);
            }else{
                uo.setStatus(USERSTATUS.OFFLINE);
            }
            uos.add(uo);
        }
        return uos;
    }

    public UserEntity getUserById(String id){
        return userRepository.findOne(id);
    }

    public List<UserEntity> queryAllUser() {
        return userRepository.findAll();
    }

    public UserEntity register(UserEntity userEntity){
        UserEntity oldUser = userRepository.findByName(userEntity.getName());
        if (null != oldUser){
            return null;
        }
        userEntity.setPass(PasswordUtil.generatePass(userEntity.getPass()));
        return userRepository.save(userEntity);
    }

    public boolean keepOnline(String uid){
        UserEntity userEntity = null;
        if(redisService.exists(uid)){
            userEntity = toEntity(redisService.get(uid));
        }else {
            userEntity = userRepository.findOne(uid);
        }
        return this.saveUserToRedis(userEntity);

    }

    public Set<UserEntityO>  getFriendInfoByUserid(String uid){
        UserEntity me = userRepository.findOne(uid);

        Set<UserEntityO> friendSet = null;
        if (null == me.getFriends()){
            return null;
        }else{
            Set<String> friendStr = me.getFriends();
            friendSet = new HashSet<UserEntityO>();
            UserEntityO fo = null;
            for(String friendid:friendStr){
                fo = new UserEntityO();
                UserEntity f = userRepository.findOne(friendid);
                fo.setUserinfo(f);
                if (redisService.exists(f.getId())){
                    fo.setStatus(USERSTATUS.ONLINE);
                }else{
                    fo.setStatus(USERSTATUS.OFFLINE);
                }
                friendSet.add(fo);
            }
        }
        return friendSet;
//        List<UserEntity> friends = userRepository.find
    }

    public Long getOnlineSize(){
        return redisService.dbSize();
    }

    public UserEntity updateUser(UserEntity userEntity){
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

    private UserEntity toEntity(String jsonStr){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonStr,UserEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
