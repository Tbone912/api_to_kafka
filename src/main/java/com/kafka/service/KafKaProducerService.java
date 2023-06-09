package com.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafKaProducerService 
{
    private static final Logger logger = 
            LoggerFactory.getLogger(KafKaProducerService.class);
     
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
 
    public void sendMessage(String user) 
    {
        logger.info(String.format("Message sent -> %s", user.toString()));
        this.kafkaTemplate.send("test", user);
    }
}