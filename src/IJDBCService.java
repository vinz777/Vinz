import JDBC.Employee;

public interface IJDBCService {
	
	public Boolean getConnection();
	
	public Employee addEmployee();
	
	public Employee getEmployee(int id);

}
