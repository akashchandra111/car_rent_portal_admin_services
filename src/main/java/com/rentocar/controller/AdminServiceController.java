package com.rentocar.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.rentocar.model.CarsBookStat;

@RestController
@RequestMapping("/admin")
public class AdminServiceController {

	@Autowired
	private RestTemplate restTemplate;
	
	private String baseURL = "http://rentocar-rest-service/";
	
	@RequestMapping("/total_users")
	public long getTotalUsers()	{
		return restTemplate.getForObject(this.baseURL + "/user/total", Long.class);
	}
	
	@RequestMapping("/stats/cars")
	public List<CarsBookStat> getBookingStatByType()	{
		// Get stat of all type
		Long availableMiniCars = restTemplate.getForObject(this.baseURL + "/car_status/available/mini", List.class).stream().count();
		Long availableMicroCars = restTemplate.getForObject(this.baseURL + "/car_status/available/micro", List.class).stream().count();
		Long availableDeluxeCars = restTemplate.getForObject(this.baseURL + "/car_status/available/deluxe", List.class).stream().count();
		Long availableSuvCars = restTemplate.getForObject(this.baseURL + "/car_status/available/suv", List.class).stream().count();
		Long bookedMiniCars = restTemplate.getForObject(this.baseURL + "/car_status/booked/mini", List.class).stream().count();
		Long bookedMicroCars = restTemplate.getForObject(this.baseURL + "/car_status/booked/micro", List.class).stream().count();
		Long bookedDeluxeCars = restTemplate.getForObject(this.baseURL + "/car_status/booked/deluxe", List.class).stream().count();
		Long bookedSuvCars = restTemplate.getForObject(this.baseURL + "/car_status/booked/suv", List.class).stream().count();
		
		return Arrays.asList(
			new CarsBookStat("mini", availableMiniCars.toString(), bookedMiniCars.toString()),
			new CarsBookStat("micro", availableMicroCars.toString(), bookedMicroCars.toString()),	
			new CarsBookStat("deluxe", availableDeluxeCars.toString(), bookedDeluxeCars.toString()),
			new CarsBookStat("suv", availableSuvCars.toString(), bookedSuvCars.toString())
		);
	}
}
