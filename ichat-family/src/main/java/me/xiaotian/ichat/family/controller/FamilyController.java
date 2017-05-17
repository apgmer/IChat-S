package me.xiaotian.ichat.family.controller;

import me.xiaotian.ichat.entity.FamilyInfos;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.entity.FamilyUserWithStatus;
import me.xiaotian.ichat.service.FamilyRelaService;
import me.xiaotian.ichat.web.common.ResultMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;


/**
 * Created by guoxiaotian on 2017/5/16.
 */
@RestController
//@Secured("USER")
@RequestMapping("/")
public class FamilyController {

    private ResultMap resultMap;

    @Resource
    private FamilyRelaService familyRelaService;

    /**
     * 获取单个家庭信息
     * @param fid
     * @return
     */
    @RequestMapping(value = "familyInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> familyInfo(@RequestParam("fid") String fid) {
        resultMap = new ResultMap();

        FamilyInfos familyInfos = familyRelaService.getAllInfoById(fid);
        if (null != familyInfos) {
            resultMap.setStatus(true);
            resultMap.setData(familyInfos);
        }else{
            resultMap.setStatus(false);
            resultMap.setData("获取信息失败");
        }
        return resultMap.getResMap();

    }

    /**
     * 删除单个家庭成员
     * @param memId
     * @param fid
     * @return
     */
    @RequestMapping(value = "delFamilyMem",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> delFamilyMem(@RequestParam("memId") String memId,@RequestParam("fid") String fid){

        resultMap = new ResultMap();
        boolean flag = familyRelaService.delMem(fid,memId);
        resultMap.setStatus(flag);
        return resultMap.getResMap();

    }

    /**
     * 添加家庭成员
     * @param fid
     * @param familyUserEntity
     * @return
     */
    @RequestMapping(value = "addFamilyMem",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addFamilyMem(@RequestParam("fid") String fid, @RequestBody FamilyUserEntity familyUserEntity){
        resultMap = new ResultMap();
        boolean flag = familyRelaService.addMem(fid,familyUserEntity);
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }

    /**
     * 查询所有用户在线信息
     * @param fid
     * @return
     */
    @RequestMapping(value = "/familyInfos",method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> familyInfos(@RequestParam("fid") String fid){
        resultMap = new ResultMap();
        Set<FamilyUserWithStatus> fus = familyRelaService.getUserAndStatusByFamily(fid);
        if (null != fus){
            resultMap.setStatus(true);
            resultMap.setData(fus);
        }else{
            resultMap.setStatus(false);
        }
        return resultMap.getResMap();
    }

}
