package com.springboot.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.rest.dao.Mydaorepository;
import com.springboot.rest.dto.PlotDTO;
import com.springboot.rest.model.Plots;
import com.springboot.rest.model.Sensor;


@Service
public class Myserviceimpl implements Myservice {


	@Autowired
	Mydaorepository dao;	

	@Override
	public List<Plots> findAllPlots() {
		List<Plots> list  = dao.getAllPlots();
		return list;
	}

	@Override
	public List<Plots> findByplotName(String plotName) {
		return dao.getPlotByName(plotName);
	}

	@Override
	public Plots addPlot(PlotDTO dto) {
		Plots plot = new Plots();
		plot.setPlotName(dto.getPlotName());
		plot.setWaterAmount(Integer.parseInt(dto.getWaterAmount()));
		plot.setTimeSlot(Integer.parseInt(dto.getTimeSlot()));
		plot.setStatus(dto.getStatus());		
		return dao.addPlot(plot);
	}

	@Override
	public Plots editPlotByName(String name,String time) {
		return dao.editPlotByName(name,time);		
	}


	@Override
	public Plots irrigate(String sensorName) {
		int retryCount = 3;
		Plots plot = null;

		while(retryCount > 0) {
			Sensor sensor = dao.getSensor(sensorName);
			if(sensor != null) {
				plot = dao.findPlotBySensor(sensor);
				if(plot != null) {
					plot = dao.irrigatePlot(plot.getPlotName());
					retryCount--;
					break;
				}
			}
			retryCount--;
		}
		System.out.println("retryCount >>>> "+retryCount);
		return plot;

	}

}