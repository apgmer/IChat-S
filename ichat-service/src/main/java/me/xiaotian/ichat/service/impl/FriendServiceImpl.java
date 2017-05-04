package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.common.ADDFRIENDSTATUS;
import me.xiaotian.ichat.entity.AddFriendMsg;
import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.repository.FriendMsgRepository;
import me.xiaotian.ichat.service.FriendService;
import me.xiaotian.ichat.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Resource
    private FriendMsgRepository friendMsgRepository;

    @Resource
    private UserService userService;

    public boolean reqAddFriend(String srcuid, String desuid) {
        AddFriendMsg oldMsg = friendMsgRepository.findAddFriendMsgsBySrcIdAndDesId(srcuid, desuid);
        if (oldMsg == null) {
            AddFriendMsg friendMsg = new AddFriendMsg();
            friendMsg.setSrcId(srcuid);
            friendMsg.setDesId(desuid);
            friendMsg.setStatus(ADDFRIENDSTATUS.SEEDING);
            return this.saveOne(friendMsg);
        } else {
            oldMsg.setStatus(ADDFRIENDSTATUS.SEEDING);
            return this.saveOne(oldMsg);
        }
    }

    public boolean replyReq(String msgId, String status) {
        AddFriendMsg friendMsg = friendMsgRepository.findOne(msgId);
        if (status.equals(ADDFRIENDSTATUS.ACCEPT )|| status.equals(ADDFRIENDSTATUS.SEEDING) || status.equals(ADDFRIENDSTATUS.REJECT) ){
            friendMsg.setStatus(status);
        }
        if (status.equals(ADDFRIENDSTATUS.ACCEPT)){
            UserEntity nowUser = userService.getUserById(friendMsg.getDesId());
            if (null == nowUser.getFriends()){
                nowUser.setFriends(new HashSet<String>());
            }
            nowUser.getFriends().add(friendMsg.getSrcId());
            userService.updateUser(nowUser);
        }

        return this.saveOne(friendMsg);
    }

    public List<AddFriendMsg> getMsg(String nowid) {
        List<AddFriendMsg> oldMsg = friendMsgRepository.findAddFriendMsgsByDesId(nowid);
        List<AddFriendMsg> newMsg = new ArrayList<AddFriendMsg>();
        for (AddFriendMsg n:oldMsg){
            if (n.getStatus().equals(ADDFRIENDSTATUS.SEEDING)){
                newMsg.add(n);
            }
        }
        return newMsg;
    }


    private boolean saveOne(AddFriendMsg friendMsg) {
        try {
            friendMsgRepository.save(friendMsg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
