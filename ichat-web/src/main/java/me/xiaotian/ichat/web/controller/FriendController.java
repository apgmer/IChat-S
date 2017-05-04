package me.xiaotian.ichat.web.controller;

import me.xiaotian.ichat.entity.AddFriendMsg;
import me.xiaotian.ichat.service.FriendService;
import me.xiaotian.ichat.web.common.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/api/friend")
public class FriendController {

    @Resource
    private FriendService friendService;

    private ResultMap resultMap = new ResultMap();

    /**
     * 发送添加朋友请求
     * @param friendMsg
     * @return
     */
    @RequestMapping(value = "/addReq",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendAddFriendReq(@RequestBody AddFriendMsg friendMsg){

        boolean flag = friendService.reqAddFriend(friendMsg.getSrcId(),friendMsg.getDesId());
        resultMap.setStatus(flag);

        return resultMap.getResMap();
    }

    /**
     * 获取添加好友通知
     * @param uid
     * @return
     */
    @RequestMapping(value = "/getfriendmsg",method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> getfriendMsg(@RequestParam("uid") String uid){
        List<AddFriendMsg> msgs = friendService.getMsg(uid);
        if (null != msgs){
            resultMap.setStatus(true);
            resultMap.setData(msgs);
        }else {
            resultMap.setStatus(false);
        }
        return resultMap.getResMap();
    }

    /**
     * 处理添加好友请求
     * @param friendMsg
     * @return
     */
    @RequestMapping(value = "/dealfriendmsg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> dealFriendMsg(@RequestBody AddFriendMsg friendMsg){
        boolean flag = friendService.replyReq(friendMsg.getId(),friendMsg.getStatus());
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }

}
