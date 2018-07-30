package com.mogateway.config;

import com.mogateway.redis.*;
import com.mogateway.service.ChargeRecordService;
import com.mogateway.util.CinTxt;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Created by Administrator on 2018-04-20.
 */
@Configuration
public class RedisSubListenerConfig {

    @Value("${spring.redis.address}")
    private String address;

    @Value("${spring.redis.logSubChannel}")
    private String logSubChannel;

    @Value("${spring.redis.eventSubChannel}")
    private String eventSubChannel;

    @Value("${spring.redis.chargeRecordSubChannel}")
    private String chargeRecordSubChannel;

    @Value("${spring.redis.processSubChannel}")
    private String processSubChannel;

    @Value("${spring.redis.realTimeSubChannel}")
    private String realTimeSubChannel;

    @Value("${spring.redis.cloudResponseChannel}")
    private String cloudResponseChannel;

    @Autowired
    private RedisUtil redisUtil;

    //初始化监听器
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            LogReceiver logReceiver,
                                            EventReceiver eventReceiver,
                                            ChargeRecordReceiver chargeRecordService,
                                            ProcessReceiver processReceiver,
                                            RealTimeReceiver realTimeReceiver,
                                            CloudResponseReceiver cloudResponseReceiver) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(logReceiver, new PatternTopic(logSubChannel));
        container.addMessageListener(eventReceiver, new PatternTopic(eventSubChannel));
        container.addMessageListener(chargeRecordService, new PatternTopic(chargeRecordSubChannel));
        container.addMessageListener(processReceiver, new PatternTopic(processSubChannel));
        container.addMessageListener(realTimeReceiver, new PatternTopic(realTimeSubChannel));
        container.addMessageListener(cloudResponseReceiver, new PatternTopic(cloudResponseChannel));
        return container;
    }

    //使用默认的工厂初始化redis操作模板
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
