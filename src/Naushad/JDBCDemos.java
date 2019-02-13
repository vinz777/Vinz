package com.lnt.day19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCDemos {
	// Type 1 driver
	// jdbc:odbc:dsn --- jdbcodbcdriver 1.8 deprecated

	//type 4 drivers.
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// String driver = "oracle.jdbc.OracleDriver";
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		
	//	DriverManager.registerDriver(new Driver());
		//second way of loading driver
		
		System.out.println("loaded");
		String url = "jdbc:mysql://localhost:3306/naushad";
		String user = "naushad";
		String password = "naushad";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("connected");

		String sql = "insert into lntemployee values(5,'Pappu')";
		Statement st = con.createStatement();
		int x = st.executeUpdate(sql);
		System.out.println(x);

		String sql1 = "select username , id  from lntemployee where name='baba'";
		Statement st1 = con.createStatement();
		ResultSet rs = st1.executeQuery(sql1);
		// boolean res = rs.next();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("username");
			System.out.println(id + " " + name);
		}
	}

}
