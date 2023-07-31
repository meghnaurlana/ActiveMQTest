package com.ActiveMQTest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActivemqService {
    JmsTemplate jmsTemplate;

    @Autowired
    public ActivemqService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void SendMessage(String message) {
        jmsTemplate.convertAndSend("A new Message", message);
    }
}
