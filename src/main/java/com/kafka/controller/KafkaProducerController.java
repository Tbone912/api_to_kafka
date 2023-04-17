package com.kafka.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.User;
import com.kafka.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController
{
	private final KafKaProducerService producerService;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService)
	{
		this.producerService = producerService;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestBody List<User> users) throws JsonProcessingException
	{
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		String user = objectMapper.writeValueAsString(users);
//		System.err.println(user);
		this.producerService.sendMessage(user);
	}
}