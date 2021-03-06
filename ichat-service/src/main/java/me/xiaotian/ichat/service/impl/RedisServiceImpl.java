package me.xiaotian.ichat.service.impl;

import me.xiaotian.ichat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by guoxiaotian on 2017/5/4.
 */
@Primary
@Service
@com.alibaba.dubbo.config.annotation.Service
public class RedisServiceImpl implements RedisService {
    private static final String CHARSET = "UTF8";

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public void setRedisTemplate(
            RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    
    public boolean set(final byte[] key, final byte[] value,
                       final long activeTime) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
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
        return this.set(key, value, 0L);
    }

    
    public boolean set(byte[] key, byte[] value) {
        return this.set(key, value, 0L);
    }

    
    public String get(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
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
        return redisTemplate.keys(pattern);

    }

    
    public boolean exists(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    
    public boolean flushDB() {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushDb();
                return true;
            }
        });
    }

    
    public long delete(final Collection<String> keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                long result = 0;
                for (String key : keys) {
                    result = connection.del(key.getBytes());
                }
                return result;
            }
        });
    }

    
    public long delete(final String... keys) {
        Collection<String> cols = new ArrayList<String>();
        for (String key : keys) {
            cols.add(key);
        }
        return this.delete(cols);
    }

    public Long dbSize() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    public List<String> getAllKeys() {
        return redisTemplate.execute(new RedisCallback<List<String>>() {
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                Set<byte[]> redisKeys = connection.keys("*".getBytes());
                List<String> keysList = new ArrayList<String>();
                Iterator<byte[]> it = redisKeys.iterator();
                while (it.hasNext()) {
                    byte[] data = (byte[])it.next();
                    keysList.add(new String(data, 0, data.length));
                }

                return keysList;
            }
        });
    }
}
