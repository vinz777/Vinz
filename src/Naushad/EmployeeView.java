package com.lnt.day20;

import java.sql.SQLException;
import java.util.List;

public class EmployeeView {
	public static void main(String[] args) throws SQLException {
		//addEmployee();
		getAllEmployees();
		//getEmployee(44);
	}
	private static void getEmployee(int id) throws SQLException {
		EmployeeDao dao = new EmployeeDao();
		EmployeeLNT employeeLNT =  dao.getEmployee(id);
		System.out.println(employeeLNT);
		
	}

	private static void getAllEmployees() throws SQLException {
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeLNT> emplist =  dao.getAllEmployees();
		for(EmployeeLNT emp : emplist) {
			System.out.println("ID :" + emp.getId() + "UserName : " + emp.getName());
		}
	}

	private static void addEmployee() throws SQLException {
		EmployeeLNT employeeLNT = new EmployeeLNT(1, "Amar");
		EmployeeDao dao = new EmployeeDao();
		boolean res = dao.addEmployee(employeeLNT);
		if(res) {
			System.out.println("Inserted"); 
		}else {
			System.out.println("Not Inserted");
		}
	}
}
