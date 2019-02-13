package JDBC;

import java.sql.SQLException;

public class JDBCDemo {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String USER = "root";
	static final String PASS = "vinzroot";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		JDBCService demo = new JDBCService();
		demo.getConnection();
		demo.addEmployee();
		//demo.getEmployee(1);
		
	}

}
