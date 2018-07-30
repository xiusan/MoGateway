package com.mogateway.redis;

import com.mogateway.contans.Constants;
import com.mogateway.util.CommonUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018-04-28.
 */
@Component
public class RealTimeReceiver implements MessageListener {

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = CommonUtils.convertMsg(redisUtil.getRedisTemplate(), message);
        if ("".equals(message) || message == null) {
            return;
        }

        JSONObject json = JSONObject.fromObject(message.toString());
        redisUtil.setValue(Constants.DATA_MANAGER_REAL_TIME+json.getString("equipmentID"),json.toString());


    }
}
