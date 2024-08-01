package com.example.tibcoems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class EmsMessageProducer {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Value("${tibco.ems.queue.name}")
    private String queueName;

    public void sendMessage(String message) {
        try (Connection connection = connectionFactory.createConnection();
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)) {

            Destination destination = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage(message);
            producer.send(textMessage);

            System.out.println("Sent message: " + message);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
