package com.company;

import javax.jms.*;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

import java.util.Random;

public class SendFilter {
    public static void main(String[] args) {
        ConnectionFactory factory;
        factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin")) {

            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination Queue = context.createQueue("FilterQueue");

            TextMessage message = context.createTextMessage();
            int num = 666;
            message.setText("Filtered by " + num);
            message.setIntProperty("magicNum", num);

            JMSProducer producer = context.createProducer();

            producer.send(Queue, message);
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}