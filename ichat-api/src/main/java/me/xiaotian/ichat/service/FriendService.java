package me.xiaotian.ichat.service;

import me.xiaotian.ichat.entity.AddFriendMsg;

import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public interface FriendService {

    /**
     * 发送添加朋友请求
     *
     * @param srcuid 自己id
     * @param desuid 朋友id
     * @return
     */
    boolean reqAddFriend(String srcuid, String desuid);


    /**
     * 处理好友请求
     * @param nowuid 当前用户id
     * @param fiendid 朋友id 发起请求id
     * @param status 同意，不同意
     *               同意：status=accept
     *               不同意: reject
     * @return
     */
    boolean replyReq(String nowuid, String fiendid, String status);


    /**
     * 查询自己发起的请求
     * @param nowid
     * @return
     */
    List<AddFriendMsg> getMsg(String nowid);

}
