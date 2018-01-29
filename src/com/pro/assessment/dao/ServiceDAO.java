package com.pro.assessment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pro.assessment.bean.Appointment;
import com.pro.assessment.database.DatabaseClass;

public class ServiceDAO {
	
	
	DatabaseClass dbc = new DatabaseClass();

	public ServiceDAO() {
		// TODO Auto-generated constructor stub
	}
	


	public String insertApptmt(String dateStr, String times, String desc) {
	
		Connection conn = dbc.getConnection();
		 

         DateFormat srcDf = new SimpleDateFormat("MM/dd/yyyy");
         DateFormat destDf = new SimpleDateFormat("MMM-dd-yyyy");

         Date date;
         String findate = null;
		try {
			date = srcDf.parse(dateStr);
			  dateStr = destDf.format(date);
			  String [] arr = dateStr.split("-");
			  findate = arr[1] + " " + arr[0] + " " + arr[2];
		         System.out.println("Converted date is : " + findate);
		} catch (ParseException e) {
	
			e.printStackTrace();
		}
		
		String time = times;
		String [] arr1 = time.split(":");
		int hr = Integer.parseInt(arr1[0]);
		String ampm;
		if(hr>=12){
			
			ampm = "pm";
			
		}else{
			ampm = "am";
		}
		
		if(hr>12) hr = hr-12;
		String fintime = hr + ":" + arr1[1] + " " + ampm;
		
		System.out.println(fintime);
		
		Statement stmt = null;
		int res = 0;
		
		 try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO Appointments(Appt_date,Appt_Time,Desc)" +
                    " VALUES('"+findate+"','"+ fintime+"','"+desc+"');"; 
			System.out.println(sql);
			res = stmt.executeUpdate(sql);
			 stmt.close();
	         
	         conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Sorry, Appointment slot is not available";
		}
		 if(res == 1) return "Appointment is created!";
		 else return "Sorry, Appointment slot is not available";
     
		

	}

	public List checkOut(String wildcard) {
		  Connection c = dbc.getConnection();
		   Statement stmt = null;
		   List list = new ArrayList();
		   try {
			     
			      c.setAutoCommit(false);

			      stmt = c.createStatement();
			      String sql = "SELECT * FROM Appointments where Desc LIKE '%"+wildcard+"%';";
			      System.out.println(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			  
			      while ( rs.next() ) {
			         String Appt_date = rs.getString("Appt_date");
			         String  Appt_Time = rs.getString("Appt_Time");
			         String Desc  = rs.getString("Desc");
			        Appointment appt = new Appointment(Appt_date,Appt_Time,Desc);
			         list.add(appt);
			      }
			      rs.close();
			      stmt.close();
			      c.close();
			   } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			   }
			 
	
		return list;
	}
}
