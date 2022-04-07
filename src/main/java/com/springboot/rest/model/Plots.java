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
@Table(name= "plots")

@DynamicInsert
@DynamicUpdate
public class Plots {

	@Id
	@Column(name="PLOT_NAME")
	private String plotName;

	@Column(name="TIME_SLOT")
	private Integer timeSlot;

	@Column(name="WATER_AMOUNT")
	private Integer waterAmount;

	@Column(name="STATUS")
	private String status;

	public Plots() { }

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Plots [plotName=" + plotName + ", timeSlot=" + timeSlot + ", waterAmount=" + waterAmount + ", status="
				+ status + "]";
	}


}