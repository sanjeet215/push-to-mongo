package com.asiczen.push.mongo.service;

import org.springframework.stereotype.Service;

import com.asiczen.push.mongo.model.AlertMessage;
import com.asiczen.push.mongo.model.TransformedMessage;

@Service
public interface MessagePushService {

	public void publishMessageToMongoDb(TransformedMessage message);

	public void publishEndOfDayDataToMongo(TransformedMessage message);

	public void publishAlertMessages(AlertMessage message);
}
