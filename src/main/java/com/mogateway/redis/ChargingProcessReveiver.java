package com.mogateway.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018-05-03.
 */
@Component
public class ChargingProcessReveiver implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {

    }
}
