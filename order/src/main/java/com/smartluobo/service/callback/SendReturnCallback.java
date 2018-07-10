package com.smartluobo.service.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/06
 * 创建时间: 21:51
 */
@Service
public class SendReturnCallback implements RabbitTemplate.ReturnCallback {

    private Logger logger = LoggerFactory.getLogger(SendReturnCallback.class);

    public void returnedMessage(Message message, int replyCode,
                                String replyText, String exchange,
                                String routingKey) {
        logger.info("Returned replyText："+replyText);
        logger.info("Returned exchange："+exchange);
        logger.info("Returned routingKey："+routingKey);
        String msgJson  = new String(message.getBody());
        logger.info("Returned Message："+msgJson);
    }
}
