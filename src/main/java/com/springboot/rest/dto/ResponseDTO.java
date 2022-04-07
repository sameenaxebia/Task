package com.springboot.rest.dto;

import com.springboot.rest.model.Plots;

public class ResponseDTO {


	private String statusmessage;

	private Plots plot;

	public String getStatusmessage() {
		return statusmessage;
	}

	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

	public Plots getPlot() {
		return plot;
	}

	public void setPlot(Plots plot) {
		this.plot = plot;
	}

	@Override
	public String toString() {
		return "ResponseDTO [statusmessage=" + statusmessage + ", plot=" + plot + "]";
	}

	

}