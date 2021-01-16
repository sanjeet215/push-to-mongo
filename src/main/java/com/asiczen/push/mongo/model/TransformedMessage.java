package com.asiczen.push.mongo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransformedMessage {

	private String imei;
	private int gps;
	private double lat;
	private double lng;
	private boolean isKeyOn;
	private int heading;
	private Date timestamp;
	private int unplugged;
	private int fuel;
	private int speed;

	// Derieved Fields
	private String vehicleNumber;
	private String vehicleType;
	private String driverName;
	private String driverContact;
	private String orgRefName;

	private double calculatedSpeed;
	private double averageSpeed;
	private double calulatedDistance;
	private double calculatedDailyDistance;
	private double topSpeed;

	// Seconds
	private int idleKeyOnTime; // Vehicle Key is on but vehicle is not moving
	private int idleKeyOffTime; // Key is off and Vehicle is not moving
	private int vehicleMovingTime; // key is on and vehicle is moving

	// Tank
	private double currentFuel;

	// Flags for Different status
	boolean idleEngineOn;
	boolean idleEngineOff;
	boolean vehicleMovingFlag;
	boolean alertFlag;
	boolean currenFlag = true;
	boolean geoViolation;
	boolean speedViolation;

	// Total Number of Messages
	int messageCounter;
}
