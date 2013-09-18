package com.cars.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProducerController {

	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);
	
	@Autowired
	RabbitTemplate amqpTemplate;
	
	@RequestMapping(value="send", method=RequestMethod.GET)
	public String produceMessage() {
		logger.info("about to send a message...");
		
		amqpTemplate.convertAndSend("Hello friends in listenerImpl");
		
		logger.info("sent a message");
		
		return "producer";
	}
	
}
