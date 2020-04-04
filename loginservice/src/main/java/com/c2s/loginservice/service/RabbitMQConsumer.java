package com.c2s.loginservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.c2s.loginservice.model.LoginUserData;
import com.c2s.loginservice.model.User;

//@Component
public class RabbitMQConsumer {
	
	/*
	 * @RabbitListener(queues = "${user.rabbitmq.queue}") public void
	 * recievedMessage(LoginUserData user) { System.out.println("in recived");
	 * System.out.println("Recieved Message From RabbitMQ: " + user); }
	 */

}
