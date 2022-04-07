package com.springboot.rest.dto;

public class PlotDTO {


	private String plotName;

	private String timeSlot;

	private String waterAmount;

	private String status;

	public PlotDTO() { }

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}	

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(String waterAmount) {
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