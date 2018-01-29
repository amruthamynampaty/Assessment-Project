package com.att.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pro.assessment.service.ParkService;

//@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@RestController
@SpringBootApplication
@ComponentScan("com.pro.assessment")
public class Parking{
	@Autowired
	ParkService ps;

	//@CrossOrigin(origins = "http://localhost:8090")
	@RequestMapping(method=RequestMethod.POST, value="/Appt")
	public String appointment(@RequestParam("ApptDate") String ApptDate, @RequestParam("ApptTime") String ApptTime,
			@RequestParam("Desc") String Desc){
		return ps.insertApptmt(ApptDate,ApptTime,Desc);
	}
	//@CrossOrigin(origins = "http://localhost:8090")
	@RequestMapping(method=RequestMethod.POST, value="/getAppt",headers="Accept=application/json")
	public List getAppt(@RequestParam("wildcard") String wildcard){
		return ps.getAppt(wildcard);
	}
	
	  public static void main(String[] args) throws Exception {
	        SpringApplication.run(Parking.class, args);
	    }
	  
/*	  @Configuration
	  @EnableWebMvc
	  public class WebConfig extends WebMvcConfigurerAdapter {

	  	@Override
	  	public void addCorsMappings(CorsRegistry registry) {
	  		registry.addMapping("/**");
	  	}
	  }*/
	
}
