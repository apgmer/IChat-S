package me.xiaotian.ichat.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
public interface RedisService {

    /**
     * <pre>
     * 通过key删除
     * @param keys
     * @return 被删除的记录数
     * </pre>
     */
    long delete(String... keys);

    /**
     * <pre>
     * 通过keys删除
     * @param keys
     * @return 被删除的记录数
     * </pre>
     */
    long delete(Collection<String> keys);

    /**
     * <pre>
     *  @param key
     *  @param value
     *  @param activeTime 秒
     *  @return 添加key value 并且设置存活时间
     * </pre>
     */
    boolean set(byte[] key, byte[] value, long activeTime);

    /**
     * <pre>
     * @param key
     * @param value
     * @param activeTime 秒
     * @return 添加key value 并且设置存活时间
     * </pre>
     */
    boolean set(String key, String value, long activeTime);

    /**
     * <pre>
     *  @param key
     *  @param value
     *  @return 添加key value
     * </pre>
     */
    boolean set(String key, String value);

    /**
     * <pre>
     *  @param key
     *  @param value
     *  @return 添加key value
     * </pre>
     */
    boolean set(byte[] key, byte[] value);

    /**
     * <pre>
     * @param key
     * @return 获得value
     * </pre>
     */
    String get(String key);

    /**
     * <pre>
     * @param pattern
     * @return 通过正则匹配keys
     * </pre>
     */
    Set<String> matchKeys(String pattern);

    /**
     * <pre>
     * @param key
     * @return 检查key是否已经存在
     * </pre>
     */
    boolean exists(String key);

    /**
     * <pre>
     * @return 清空所有数据
     * </pre>
     */
    boolean flushDB();

    /**
     * 查看有多少条数据
     * @return
     */
    Long dbSize();

    /**
     * 获取所有的key
     * @return
     */
    List<String> getAllKeys();

}
