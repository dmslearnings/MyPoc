package com.example.tibcoems.controller;

import com.example.tibcoems.service.EmsMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmsController {

    @Autowired
    private EmsMessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}
//http://localhost:8080/send?message=HelloWorld
