package com.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.User;

@Service
public class KafKaConsumerService {
	private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

//	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(String message, User user) {
//        logger.info(String.format("Message recieved -> %s", message));
//        logger.info(String.format("Json recieved -> %s", user));
		System.err.println(user);

	}
}