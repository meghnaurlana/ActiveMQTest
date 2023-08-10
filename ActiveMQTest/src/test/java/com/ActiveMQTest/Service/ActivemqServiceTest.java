package com.ActiveMQTest.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ActivemqServiceTest {
    @Autowired
    ActivemqService activemqService;

    @MockBean
    JmsTemplate jmsTemplate;

    @Test
    void sendMessage() {
        String message = "Hello";
        activemqService.SendMessage(message);
        verify(jmsTemplate, times(1)).convertAndSend("A new Message", message);
    }
}
