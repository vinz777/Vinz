package com.lnt.day20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {

	private Connection con = GetDatabaseConnection.getConnection();

	public EmployeeLNT getEmployee(int id) throws SQLException {
		String sql = "select * from lntemployee where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs =  ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		
		System.out.println(rsmd.getTableName(1));
		
		EmployeeLNT employeeLNT = null;
		if(rs.next()) {
			int ids = rs.getInt(1);
			String name = rs.getString(2);
			employeeLNT = new EmployeeLNT(ids, name);
		}
		return employeeLNT;
	}
	
	public boolean addEmployee(EmployeeLNT emp) throws SQLException {
		int id = emp.getId();
		String name = emp.getName();

		String sql = "insert into lntemployee values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		int res = ps.executeUpdate();
		if (res > 0) {
			return true;
		}
		return false;
	}

	public List<EmployeeLNT> getAllEmployees() throws SQLException {
		
		List<EmployeeLNT> emplist = new ArrayList<>();
		String sql = "select * from lntemployee";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			EmployeeLNT employeeLNT = new EmployeeLNT(id,name);
			emplist.add(employeeLNT);
		}
		return emplist;
	}
	public static void main(String[] args) throws SQLException {
		
		new EmployeeDao().getEmployee(4);
		
	}
}
