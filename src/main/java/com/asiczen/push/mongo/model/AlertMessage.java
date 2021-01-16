package com.asiczen.push.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "alertmessages")
@EqualsAndHashCode(callSuper = false)
public class AlertMessage {

	private String orgRefName;
	private String vehicleNumber;
	private String driverName;
	private AlertType alertType;
}
