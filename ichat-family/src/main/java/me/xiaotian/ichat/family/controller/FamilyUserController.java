package me.xiaotian.ichat.family.controller;

import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.service.FamilyUserService;
import me.xiaotian.ichat.web.common.ResultMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@RestController
@RequestMapping("/")
public class FamilyUserController {

    private ResultMap resultMap = null;

    @Resource
    private FamilyUserService familyUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody FamilyUserEntity familyUserEntity) {

        resultMap = new ResultMap();
        FamilyUserEntity dbu = familyUserService.login(familyUserEntity);
        if (null != dbu){
            resultMap.setStatus(true);
            resultMap.setData(new HashSet<FamilyUserEntity>().add(dbu));
        }else{
            resultMap.setStatus(false);
            resultMap.setData("用户名密码错误");
        }
        return resultMap.getResMap();

    }

}
