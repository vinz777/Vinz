package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCService {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String USER = "root";
	static final String PASS = "vinzroot";
	Connection con;
	
	public Boolean getConnection() throws ClassNotFoundException, SQLException {
		//Class.forName(JDBC_DRIVER);
	    con = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("connected");
		return true;
	}
	
	public Employee addEmployee() throws SQLException {
		String sql = "insert into Employees values(114,'Vic1','Z',10)";
		Statement st = con.createStatement();
		int x = st.executeUpdate(sql);
		System.out.println(x);
		return null;
	}

	public Employee getEmployee(int empId) throws SQLException {
		String sql1 = "select lastname , id  from Employees where firstname='Vin'";
		//String sql1 = "select lastname , id  from Employees where firstname="+Vin+;
		Statement st1 = con.createStatement();
		ResultSet rs = st1.executeQuery(sql1);
		//Employee emp = rs;
		//boolean res = rs.next();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("firstname");
			System.out.println(id + " " + name);
		}
		return null;
	}

}
