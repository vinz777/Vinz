package com.lnt.day19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCDemo2 {
public static void main(String[] args)throws Exception {
	
	// String driver = "oracle.jdbc.OracleDriver";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			System.out.println("loaded");
			String url = "jdbc:mysql://localhost:3306/naushad";
			String user = "naushad";
			String password = "naushad";

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("connected");

			String sql = "insert into lntemployee values(?,?)";
			//Statement st = con.createStatement();
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt(1, 22);
			ps.setString(2, "raja");
			int x = ps.executeUpdate();
			System.out.println(x);

			String sql1 = "select *  from lntemployee where username=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, "raja");
			ResultSet rs = ps1.executeQuery();
			// boolean res = rs.next();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("username");
				System.out.println(id + " " + name);
			}
		}

	

}
