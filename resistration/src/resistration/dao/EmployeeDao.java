package resistration.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import resistration.model.Employee;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee, Integer id) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO ram" +
	        " (id,name,email,password) VALUES " +
				" (?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/rahul","root","");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			    preparedStatement.setInt(1,id);
			    preparedStatement.setString(2,employee.getName());
			    preparedStatement.setString(3,employee.getEmail());
			    preparedStatement.setString(4,employee.getPassword());
			    
			    result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        try {
			result = getLatestId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    }
	
	public  int getLatestId() throws ClassNotFoundException, SQLException {
		String INSERT_USERS_SQL = "select max(id) from ram";
		
		java.sql.ResultSet result = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		int finalResult = 0;
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/rahul","root","");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			    
			    result = preparedStatement.executeQuery();
			    while(result.next()) {
			    finalResult = result.getInt(1);	
			    }
		} catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }finally {
        	result.close();
        }
		
        return finalResult;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
