package com.ActiveMQTest.controller;

import com.ActiveMQTest.Service.ActivemqService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ActivemqControllerTest {
    @MockBean
    ActivemqService activemqService;
    @MockBean
    MockMvc mockMvc;
    @MockBean
    JmsTemplate jmsTemplate;

    @Test
    void sendMessage() throws Exception {
        String message = "Hello";
        when(activemqService.SendMessage(message)).thenReturn(message);
        mockMvc.perform(post("/send/{message}", "hello")
                        .param("message", message))
                .andExpect(status().isOk());
        String receivedMessage = (String) jmsTemplate.receiveAndConvert("A new Message");
        assertEquals(receivedMessage, message);
    }
}