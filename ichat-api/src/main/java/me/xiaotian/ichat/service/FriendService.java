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
     * @param msgId msgid
     * @param status 同意，不同意
     *               同意：status=accept
     *               不同意: reject
     * @return
     */
    boolean replyReq(String msgId, String status);


    /**
     * 查询发给自己的请求
     * @param nowid
     * @return
     */
    List<AddFriendMsg> getMsg(String nowid);

    /**
     * 查询自己发送的请求
     * @param uid 用户id
     * @return
     */
    List<AddFriendMsg> getReqMsg(String uid);


    /**
     * 将消息设置为完成
     * @param uid
     * @param msgid
     * @return
     */
    boolean setMsgDone(String uid, String msgid);

}
