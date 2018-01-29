package com.pro.assessment.bean;

public class Appointment {
	
	String ApptDate;
	String ApptTime;
	String Desc;
	public Appointment(String apptDate, String apptTime, String desc) {
		super();
		ApptDate = apptDate;
		ApptTime = apptTime;
		Desc = desc;
	}
	public String getApptDate() {
		return ApptDate;
	}
	public void setApptDate(String apptDate) {
		ApptDate = apptDate;
	}
	public String getApptTime() {
		return ApptTime;
	}
	public void setApptTime(String apptTime) {
		ApptTime = apptTime;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}

}
