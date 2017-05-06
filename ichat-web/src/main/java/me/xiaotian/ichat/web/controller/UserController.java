package me.xiaotian.ichat.web.controller;

import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.entity.UserEntityO;
import me.xiaotian.ichat.service.UserService;
import me.xiaotian.ichat.web.common.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/api")
public class UserController {

    private ResultMap resultMap = null;

    @Resource
    private UserService userService;

    /**
     * 用户登陆
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> login(@RequestBody UserEntity userEntity){
        UserEntity newUser = userService.login(userEntity.getName(),userEntity.getPass());
        resultMap = new ResultMap();
        if (null != newUser){
            List<UserEntity> userEntities = new ArrayList<UserEntity>();
            userEntities.add(newUser);
            resultMap.setStatus(true);
            resultMap.setData(userEntities);
        }else{
            resultMap.setStatus(false);
        }

        return resultMap.getResMap();
    }

    /**
     * 用户注册
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/register" ,method = {RequestMethod.POST})
    @ResponseBody
    public Map<String ,Object> register(@RequestBody UserEntity userEntity){
        UserEntity newUser = userService.register(userEntity);
        resultMap = new ResultMap();
        if (null != newUser){
            resultMap.setStatus(true);
            List<UserEntity> userEntities = new ArrayList<UserEntity>();
            userEntities.add(newUser);
            resultMap.setData(userEntities);
        }else{
            resultMap.setStatus(false);
            resultMap.setData("用户名重复");
        }
        return resultMap.getResMap();
    }

    /**
     * 用户搜索
     * @param name
     * @return
     */
    @RequestMapping(value = "/user/search",method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> searchUser(@RequestParam("name") String name){
        resultMap = new ResultMap();
        Set<UserEntityO> userList = userService.searchByName(name);
        if (null != userList){
            resultMap.setStatus(true);
            resultMap.setData(userList);
        }else{
            resultMap.setStatus(false);
        }
        return resultMap.getResMap();
    }

    /**
     * 保持用户在线
     * @param uid
     * @return
     */
    @RequestMapping(value = "/user/keepOnline",method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> keepOnline(@RequestParam("uid")String uid){
        resultMap = new ResultMap();
        boolean flag = userService.keepOnline(uid);
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }

    /**
     * 获得用户详情
     * @param uid
     * @return
     */
    @RequestMapping(value = "/user/findById",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> findUserById(@RequestParam("uid") String uid){
        resultMap = new ResultMap();
        UserEntity u = userService.getUserById(uid);
        if (null != u){
            resultMap.setStatus(true);
            resultMap.setData(u);
        }else{
            resultMap.setStatus(false);
        }
        return resultMap.getResMap();
    }

}
