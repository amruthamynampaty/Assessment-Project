package com.pro.assessment.database;

import java.sql.*;

public class SQLiteJDBC {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE Appointments " +
                        "(Appt_date TEXT    NOT NULL," +
                        " Appt_Time TEXT    NOT NULL, " + 
                        " Desc TEXT     NOT NULL, PRIMARY KEY (Appt_date, Appt_Time,Desc))"; 	
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}