package com.mogateway.redis;

import com.mogateway.util.CommonUtils;
import com.mogateway.util.Const;
import net.sf.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018-01-09.
 */
@Component
public class RedisUtil {

    @Resource(name = "redisTemplate")
    private RedisTemplate<Serializable, Object> redisTemplate;

    public boolean setValue(String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object getValue(String key) {
        Object result = null;
        if (exists(key)) {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            result = operations.get(key);
            return result;
        } else {
            return null;
        }
    }

    /**
     * 向特定频道推送消息
     * @param msg 消息内容
     * @param channel 频道名称
     */
    public void pubMsg(Object msg, String channel) {
        redisTemplate.convertAndSend(channel, msg);
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);

        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    public void pubLog(String moduleID, String modeluName, String userID, String content) {
        JSONObject json = new JSONObject();
        json.put("moduleID", moduleID);
        json.put("moduleName", modeluName);
        json.put("userID", userID);
        json.put("content", content);
        json.put("time", CommonUtils.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss"));
        pubMsg(json.toString(), Const.LOG_CHANNEL);
    }

    public RedisTemplate<Serializable, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
