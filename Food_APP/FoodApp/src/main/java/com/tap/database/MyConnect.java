package com.tap.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnect {

	private static Connection con;

	public static Connection connect(){
		
		String url="jdbc:mysql://localhost:3306/food_delivery";
		String dbun="root";
		String dbpwd="masood395";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, dbun, dbpwd);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
