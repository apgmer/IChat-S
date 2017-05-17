package me.xiaotian.ichat.family.controller;

import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.service.FamilyUserService;
import me.xiaotian.ichat.web.common.ResultMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@RestController
@RequestMapping("/")
public class FamilyUserController {

    private ResultMap resultMap = null;

    @Resource
    private FamilyUserService familyUserService;

    /**
     * 登录
     * @param familyUserEntity
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody FamilyUserEntity familyUserEntity) {

        resultMap = new ResultMap();
        FamilyUserEntity dbu = familyUserService.login(familyUserEntity);
        if (null != dbu){
            resultMap.setStatus(true);
            Set<FamilyUserEntity> f = new HashSet<FamilyUserEntity>();
            f.add(dbu);
            resultMap.setData(f);
        }else{
            resultMap.setStatus(false);
            resultMap.setData("用户名密码错误");
        }
        return resultMap.getResMap();

    }

    /**
     * 发送注册验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "regcode",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> regCode(@RequestParam("phone") String phone){
        resultMap = new ResultMap();
        boolean flag = familyUserService.sendRegCode(phone);
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }

    /**
     * 注册
     * @param familyUserEntity
     * @param regcode
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(@RequestBody FamilyUserEntity familyUserEntity,@RequestParam("regcode") String regcode){
        resultMap = new ResultMap();
        boolean flag = familyUserService.reg(familyUserEntity,regcode);
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }

    /**
     * 保持用户在线
     * @param uid
     * @return
     */
    @RequestMapping(value = "keepOnline",method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> keepOnline(@RequestParam("uid")String uid){
        resultMap = new ResultMap();
        boolean flag = familyUserService.keepOnline(uid);
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }

}
