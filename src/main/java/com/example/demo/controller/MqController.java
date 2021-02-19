package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.mq.DirectSender;
import com.example.demo.mq.FanoutSender;
import com.example.demo.mq.SimpleSender;
import com.example.demo.mq.TopicSender;
import com.example.demo.mq.WorkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linaq
 * @date 2021-02-19
 */
@RestController
@RequestMapping("mq")
public class MqController extends ApiController {
    @Autowired
    private SimpleSender simpleSender;

    @Autowired
    private WorkSender workSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private TopicSender topicSender;

    /**
     * 普通模式 一个生产者、一个消费者和一个队列
     */
    @GetMapping("/simple")
    public R simple() {
        simpleSender.send();
        return success("");
    }

    /**
     * 工作模式 一个生产者、两个消费者和一个队列
     */
    @GetMapping("/work")
    public R work() {
        for (int i = 0; i < 10; i++) {
            workSender.send(i);
        }
        return success("");
    }

    /**
     * 发布/订阅模式
     * 一个名为exchange.fanout的交换机、一个生产者、两个消费者和两个匿名队列，将两个匿名队列都绑定到交换机
     */
    @GetMapping("/fanout")
    public R fanout() {
        for (int i = 0; i < 10; i++) {
            fanoutSender.send(i);
        }
        return success("");
    }

    /**
     * 路由模式
     * 创建一个名为exchange.direct的交换机、
     * 一个生产者、两个消费者和两个匿名队列，
     * 队列通过路由键都绑定到交换机，
     * 队列1的路由键为orange和black，队列2的路由键为green和black；
     */
    @GetMapping("/direct")
    public R direct() {
        for (int i = 0; i < 10; i++) {
            directSender.send(i);
        }
        return success("");
    }

    /**
     * 通配符模式
     * 创建一个名为exchange.topic的交换机、
     * 一个生产者、两个消费者和两个匿名队列，
     * 匹配*.orange.*和*.*.rabbit发送到队列1
     * 匹配lazy.#发送到队列2
     */
    @GetMapping("/topic")
    public R topic() {
        for (int i = 0; i < 10; i++) {
            topicSender.send(i);
        }
        return success("");
    }
}
