package com.mogateway.redis;

import com.alibaba.fastjson.JSON;
import com.mogateway.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018-04-26.
 */
@Component
public class ProcessReceiver extends ProcessT implements MessageListener {


    private CountDownLatch latch;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${log_path}")
    private String logPath;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = CommonUtils.convertMsg(redisUtil.getRedisTemplate(), message);
        receiveMessage(msg);
    }

    /**
     * 接收消息
     *
     * @param message {
     *                    "fielType": "car",
     *                    "equipmentID": "00101",
     *                    "currentDTTM": "2018-04-09 16:57:26",
     *                    "message": "88 01 00 08 10 4C 1a bb 00 00 00"
     *                }
     *
     */
    public void receiveMessage(String message) {
        synchronized (OBJECT) {
            try {
                lock.lock();

                logger.debug("接收到的消息: <" + message + ">");
                com.alibaba.fastjson.JSONObject object = JSON.parseObject(message);
                FileUtils.createFile(logPath + "/file", object.getString("equipmentID"));

                redisTemplate.opsForValue().set(object.getString("equipmentID") + "_log", message);

                //写入文件
                String filePath = logPath + "/file/" + object.getString("equipmentID");
                String fileMessage = object.getString("currentDTTM") + "," + object.getString("message");
                CinTxt.setTxtData(filePath, fileMessage);
            } catch (Exception e) {
                logger.error("{}", e);
            } finally {
                lock.unlock();
                latch.countDown();
            }
        }

    }


}
