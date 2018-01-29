package com.att.assessment.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pro.assessment.bean.Appointment;
import com.pro.assessment.service.ParkService;

public class ServiceTest {
	
	private ParkService parkService = new ParkService();


	@Test
	public void enterValuesSuccess() {
		
		String result = parkService.insertApptmt("01/30/2018", "15:00", "test");
		assertEquals(result,"Appointment is created!");
		
	}
	
	@Test
	public void enterValuesFail() {
		

		String result = parkService.insertApptmt("01/30/2018", "15:00", "test");
	assertEquals(result,"Sorry, Appointment slot is not available");
				
	}
	
	@Test
	public void checksSearch() {
		
		List<Appointment> result=parkService.getAppt("test");
		for(Appointment li : result){
			
			String desc = li.getDesc();
			assertEquals(true,desc.contains("test"));
		}
					}
		



}
