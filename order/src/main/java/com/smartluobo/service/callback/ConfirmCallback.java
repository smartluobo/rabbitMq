package com.smartluobo.service.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/06
 * 创建时间: 21:43
 */
@Service
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {
    private Logger logger = LoggerFactory.getLogger(ConfirmCallback.class);

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.info("消息确认发送给mq成功");
        } else {
            //处理失败的消息
            logger.info("消息发送给mq失败,考虑重发:"+cause);
        }
    }
}
