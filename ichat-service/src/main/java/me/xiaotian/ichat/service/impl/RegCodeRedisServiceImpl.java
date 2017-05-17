package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by guoxiaotian on 2017/5/17.
 */

@Service
@com.alibaba.dubbo.config.annotation.Service
public class RegCodeRedisServiceImpl implements RedisService {

    private static final String CHARSET = "UTF8";

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate2;

    public void setRedisTemplate(
            RedisTemplate<String, Serializable> redisTemplate2) {
        this.redisTemplate2 = redisTemplate2;
    }


    public long delete(String... keys) {
        return 0;
    }

    public long delete(Collection<String> keys) {
        return 0;
    }

    public boolean set(final byte[] key, final byte[] value,
                       final long activeTime) {
        return redisTemplate2.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                boolean rs = true;
                connection.set(key, value);
                if (activeTime > 0) {
                    rs = connection.expire(key, activeTime);
                }
                return rs;
            }
        });
    }


    public boolean set(String key, String value, long activeTime) {
        return this.set(key.getBytes(), value.getBytes(), activeTime);
    }


    public boolean set(String key, String value) {
        return false;
    }

    public boolean set(byte[] key, byte[] value) {
        return false;
    }

    public String get(final String key) {
        return redisTemplate2.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                try {
                    byte[] value = connection.get(key.getBytes());
                    return value == null ? "" : new String(value, CHARSET);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }


    public Set<String> matchKeys(String pattern) {
        return null;
    }

    public boolean exists(final String key) {
        return redisTemplate2.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    public boolean flushDB() {
        return false;
    }

    public Long dbSize() {
        return null;
    }

    public List<String> getAllKeys() {
        return null;
    }
}
