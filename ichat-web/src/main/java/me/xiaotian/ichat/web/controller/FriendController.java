package me.xiaotian.ichat.web.controller;

import me.xiaotian.ichat.entity.AddFriendMsg;
import me.xiaotian.ichat.entity.UserEntityO;
import me.xiaotian.ichat.service.FriendService;
import me.xiaotian.ichat.service.UserService;
import me.xiaotian.ichat.web.common.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/api/friend")
public class FriendController {

    @Resource
    private FriendService friendService;

    @Resource
    private UserService userService;

    private ResultMap resultMap = null;

    /**
     * 发送添加朋友请求
     * @param friendMsg
     * @return
     */
    @RequestMapping(value = "/addReq",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendAddFriendReq(@RequestBody AddFriendMsg friendMsg){
        resultMap = new ResultMap();
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
        resultMap = new ResultMap();
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
        resultMap = new ResultMap();
        boolean flag = friendService.replyReq(friendMsg.getId(),friendMsg.getStatus());
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }


    /**
     * 获取用户好友信息以及在线信息
     * @param uid
     * @return
     */
    @RequestMapping(value = "/getfriends", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String ,Object> getFriends(@RequestParam("uid") String uid){
        resultMap = new ResultMap();
        Set<UserEntityO> friends = userService.getFriendInfoByUserid(uid);
        if (null != friends){
            resultMap.setStatus(true);
            resultMap.setData(friends);
        }else{
            resultMap.setStatus(false);
        }
        return resultMap.getResMap();
    }

    /**
     * 获取自己发起的通知
     * @param uid
     * @return
     */
    @RequestMapping(value = "/getNotify", method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> getNotify(@RequestParam("uid") String uid){
        resultMap = new ResultMap();
        List<AddFriendMsg> notify = friendService.getReqMsg(uid);
        if (null != notify){
            resultMap.setStatus(true);
            resultMap.setData(notify);
        }else{
            resultMap.setStatus(false);
        }
        return resultMap.getResMap();
    }

    @RequestMapping(value = "/setNotifyDone", method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> setNotifyDone(@RequestParam("uid") String uid, @RequestParam("msgid") String msgId){
        resultMap = new ResultMap();
        boolean flag = friendService.setMsgDone(uid,msgId);
        resultMap.setStatus(flag);
        return resultMap.getResMap();
    }
}
