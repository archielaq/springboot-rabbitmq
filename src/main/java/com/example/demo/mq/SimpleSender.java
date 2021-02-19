package com.example.demo.mq;

import com.example.demo.common.CommonConstant;
import com.example.demo.entity.DevInfo;
import com.example.demo.service.DevInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author linaq
 * @date 2021-02-19
 */
public class SimpleSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DevInfoService devInfoService;

    private static final String queueName = CommonConstant.Mq.QUEUE_SIMPLE;

    public void send() {
        DevInfo message = devInfoService.getById(14077);
        this.template.convertAndSend(queueName, message);
        LOGGER.info(" [x] Sent '{}'", message);
    }

}
