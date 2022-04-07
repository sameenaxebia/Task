package com.springboot.rest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.springboot.rest.model.Plots;
import com.springboot.rest.model.Sensor;


@Repository
public class Mydaorepository {


	@PersistenceContext
	private EntityManager entityManager;


	public List<Plots> getAllPlots() {

		String str = "SELECT * FROM plots";
		Query query = entityManager.createNativeQuery(str,Plots.class);
		List<Plots> list = query.getResultList();
		return list;

	}

	public List<Plots> getPlotByName(String name) {

		String str = "SELECT * FROM plots where plot_name = '"+name+"'";
		Query query = entityManager.createNativeQuery(str,Plots.class);
		List<Plots> list = query.getResultList();
		return list;

	}

	@Transactional
	public Plots addPlot(Plots plot) {
		return entityManager.merge(plot);
	}

	@Transactional
	public Plots editPlotByName(String name,String time) {
		String str = "update plots set TIME_SLOT = " + time+" where plot_name = '"+name+"'";
		Query query = entityManager.createNativeQuery(str,Plots.class);
		query.executeUpdate();
		return getPlotByName(name).get(0);
	}

	@Transactional
	public Plots irrigatePlot(String name) {
		String str = "update plots set status = 'IRRIGATED' where plot_name = '"+name+"'";
		Query query = entityManager.createNativeQuery(str,Plots.class);
		query.executeUpdate();
		return getPlotByName(name).get(0);
	}

	public Sensor getSensor(String sensorName) {		
		String str = "SELECT * FROM sensor where device_name = '"+sensorName+"'";		
		Query query = entityManager.createNativeQuery(str,Sensor.class);
		if(query.getSingleResult() != null) {
			Sensor sensor =  (Sensor) query.getSingleResult();		
			return sensor;
		}else {
			return null;
		}
	}

	public Plots findPlotBySensor(Sensor sensor) {
		try {
			String str = "SELECT * FROM plots where TIME_SLOT = "+sensor.getTimeSlot() + " and WATER_AMOUNT = "+sensor.getWaterAmount();
			Query query = entityManager.createNativeQuery(str,Plots.class);
			return (Plots) query.getSingleResult();
		} catch (Exception e) {			
			return null;
		}

	}

}