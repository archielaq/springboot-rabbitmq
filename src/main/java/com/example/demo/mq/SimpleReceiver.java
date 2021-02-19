package com.example.demo.mq;

import com.example.demo.common.CommonConstant;
import com.example.demo.entity.DevInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author linaq
 * @date 2021-02-19
 */
@RabbitListener(queues = CommonConstant.Mq.QUEUE_SIMPLE)
public class SimpleReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleReceiver.class);

    @RabbitHandler
    public void receive(@Payload DevInfo message) {
        LOGGER.info(" [x] Received '{}'", message);
    }

}
