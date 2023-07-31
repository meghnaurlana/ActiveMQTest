package com.ActiveMQTest.controller;

import com.ActiveMQTest.Service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ActivemqController {
    @Autowired
    ActivemqService activemqService;

    @GetMapping("/send/{message}")
    public String SendMessage(@PathVariable("message") String message) {
        activemqService.SendMessage(message);
        return "Message received : " + message;
    }
}
