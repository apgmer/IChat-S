package me.xiaotian.ichat.repository;

import me.xiaotian.ichat.entity.AddFriendMsg;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public interface FriendMsgRepository extends MongoRepository<AddFriendMsg, String>{

    /**
     * 查询通知自己的通知
     * @param desId 自己id
     * @return
     */
    List<AddFriendMsg> findAddFriendMsgsByDesId(@Param("desId") String desId);


    /**
     * 查询具体通知
     * @param srcId
     * @param desId
     * @return
     */
    AddFriendMsg findAddFriendMsgsBySrcIdAndDesIdAndStatus(@Param("srcId") String srcId, @Param("desId") String desId);


}
