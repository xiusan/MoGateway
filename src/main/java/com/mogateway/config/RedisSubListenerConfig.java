package com.mogateway.config;

import com.mogateway.redis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * Created by Administrator on 2018-04-20.
 */
@Configuration
public class RedisSubListenerConfig {

    @Value("${spring.redis.address}")
    private String address;


    @Value("${spring.redis.eventSubChannel}")
    private String eventSubChannel;

    @Autowired
    private RedisUtil redisUtil;

    //初始化监听器
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            EventReceiver eventReceiver,
                                            ProcessReceiver processReceiver,
                                            RealTimeReceiver realTimeReceiver ) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(eventReceiver, new PatternTopic(eventSubChannel));
        return container;
    }

    //使用默认的工厂初始化redis操作模板
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
