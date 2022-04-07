package com.springboot.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.rest.dto.PlotDTO;
import com.springboot.rest.dto.ResponseDTO;
import com.springboot.rest.model.Plots;
import com.springboot.rest.service.Myservice;

@RestController
public class Mycontroller {

	@Autowired
	Myservice service;

	@RequestMapping(value= "/getAllPlots", method= RequestMethod.GET)
	public List<Plots> getAllPlots() {
		return service.findAllPlots();
	}

	@GetMapping("/getByplotName")
	@ResponseBody
	public List<Plots> getByplotName(@RequestParam String plotName) {
		return service.findByplotName(plotName);
	}	

	@RequestMapping(value= "/addPlot", method= RequestMethod.POST)
	public Plots addPlot(@RequestBody PlotDTO dto) {
		return service.addPlot(dto);
	}


	@GetMapping("/editPlotByName")
	@ResponseBody
	public Plots editPlotByName(@RequestParam String name,@RequestParam String time) {
		return service.editPlotByName(name,time);

	}

	
	@GetMapping("/irrigatePlot")
	@ResponseBody
	public ResponseDTO irrigatePlot(@RequestParam String sensorName) {
		
		ResponseDTO response = new ResponseDTO();
		Plots plot = service.irrigate(sensorName);
		if(plot != null) {
			response.setStatusmessage("successfully irriragated");
			response.setPlot(plot);			
		}else {
			response.setStatusmessage("Do not have sensor available to irrigate");
		}
		return response;

	}	
}