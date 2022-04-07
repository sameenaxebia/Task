package com.springboot.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component

@Entity
@Table(name= "sensor")

@DynamicInsert
@DynamicUpdate
public class Sensor {

	@Id
	@Column(name="DEVICE_NAME")
	private String sensorName;

	@Column(name="TIME_SLOT")
	private Integer timeSlot;

	@Column(name="WATER_LEVEL")
	private Integer waterAmount;


	public Sensor() { }


	public String getSensorName() {
		return sensorName;
	}


	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}


	public Integer getTimeSlot() {
		return timeSlot;
	}


	public void setTimeSlot(Integer timeSlot) {
		this.timeSlot = timeSlot;
	}


	public Integer getWaterAmount() {
		return waterAmount;
	}


	public void setWaterAmount(Integer waterAmount) {
		this.waterAmount = waterAmount;
	}


	@Override
	public String toString() {
		return "Sensor [sensorName=" + sensorName + ", timeSlot=" + timeSlot + ", waterAmount=" + waterAmount + "]";
	}


}