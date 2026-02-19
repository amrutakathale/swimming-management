package com.swim.scm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con;
	private static String Url ="jdbc:mysql://localhost:3306/swim_db";
	private static String Root="root";
	private static String Password="Amruta@143";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(Url,Root,Password);
			
		}catch(Exception e) {e.printStackTrace();}
		return con;
		
	}

}
