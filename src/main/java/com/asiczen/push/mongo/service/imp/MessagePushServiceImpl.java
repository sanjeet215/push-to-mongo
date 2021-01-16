package com.asiczen.push.mongo.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import com.asiczen.push.mongo.model.AlertMessage;
import com.asiczen.push.mongo.model.EndOfDayMessage;
import com.asiczen.push.mongo.model.MongoFormatMessage;
import com.asiczen.push.mongo.model.TransformedMessage;
import com.asiczen.push.mongo.repository.AlertMessageRepository;
import com.asiczen.push.mongo.repository.EndOfDayMessageRepository;
import com.asiczen.push.mongo.repository.MongoFormatMessageRepository;
import com.asiczen.push.mongo.service.MessagePushService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessagePushServiceImpl implements MessagePushService {

	@Autowired
	MongoFormatMessageRepository mongoRepo;

	@Autowired
	EndOfDayMessageRepository eodMessageRepo;

	@Autowired
	AlertMessageRepository alertMessageRepo;

	@Override
	public void publishMessageToMongoDb(TransformedMessage message) {

		MongoFormatMessage formatMessage = new MongoFormatMessage();
		BeanUtils.copyProperties(message, formatMessage);
		formatMessage.setLocation(new GeoJsonPoint(message.getLng(), message.getLat()));

		mongoRepo.save(formatMessage);
	}

	@Override
	public void publishEndOfDayDataToMongo(TransformedMessage message) {
		EndOfDayMessage eodMessage = new EndOfDayMessage();
		BeanUtils.copyProperties(message, eodMessage);
		eodMessage.setLocation(new GeoJsonPoint(message.getLng(), message.getLat()));

		eodMessageRepo.save(eodMessage);
	}

	@Override
	public void publishAlertMessages(AlertMessage message) {
		alertMessageRepo.save(message);
	}

}
