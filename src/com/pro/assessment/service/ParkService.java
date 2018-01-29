package com.pro.assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pro.assessment.dao.ServiceDAO;

@Service
@ComponentScan("com.pro.assessment")
public class ParkService {
	
	ServiceDAO sd = new ServiceDAO();

	
	public String insertApptmt(String apptDate, String apptTime, String desc){
		
		return sd.insertApptmt(apptDate,apptTime,desc);
	}
	
	public List getAppt(String wildcard) {
		// TODO Auto-generated method stub
		return sd.checkOut(wildcard);
	}

}
