package com.lnt.day20;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetDatabaseConnection {
	private static Connection con;
	static{
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			System.out.println("loaded");
			String url = "jdbc:mysql://localhost:3306/naushad";
			String user = "naushad";
			String password = "naushad";
			con = DriverManager.getConnection(url, user, password);
			DatabaseMetaData dbmd =  con.getMetaData();
			String db = dbmd.getDatabaseProductName();
			System.out.println(db);
			System.out.println(dbmd.getDriverVersion());
			System.out.println(dbmd.getDatabaseProductVersion());
			
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static void main(String[] args) {
		
		GetDatabaseConnection.getConnection();
		
	}

}
