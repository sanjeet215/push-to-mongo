package com.asiczen.push.mongo.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiczen.push.mongo.model.AlertMessage;
import com.asiczen.push.mongo.model.TransformedMessage;
import com.asiczen.push.mongo.service.MessagePushService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageConsumer {

	@Autowired
	MessagePushService service;

	@RabbitListener(queues = "covertedMessages")
	public void onMessageReceipt(TransformedMessage message) {
		try {
			service.publishMessageToMongoDb(message);
		} catch (Exception ep) {
			log.error("Error while pusing messages to Mongo Db");
		}
	}

	@RabbitListener(queues = "eodmsg-queue")
	public void onEodMessageReceipt(TransformedMessage message) {

		try {
			service.publishEndOfDayDataToMongo(message);
		} catch (Exception ep) {
			log.error("Error while publishing EOD messages.--> {} ", ep.getLocalizedMessage());
		}

	}

	@RabbitListener(queues = "alert-messages")
	public void onAlertMessageReceipt(AlertMessage message) {

		try {
			service.publishAlertMessages(message);
		} catch (Exception ep) {
			log.error("Error while publishing EOD messages.--> {} ", ep.getLocalizedMessage());
		}
	}

}
