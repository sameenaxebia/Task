package com.springboot.rest.service;

import java.util.List;
import com.springboot.rest.dto.PlotDTO;
import com.springboot.rest.model.Plots;


public interface Myservice {


	List<Plots> findAllPlots();

	List<Plots> findByplotName(String plotName);

	Plots addPlot(PlotDTO plot);

	Plots editPlotByName(String name, String time);

	Plots irrigate(String sensorName);


}