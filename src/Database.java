import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	//private ResultSet resultSetData= null;
	private Connection connection = null;
	private Statement statement = null;
	//ResultSet resultSet = null;
	private ResultSet resultSet;
	
	public ResultSet getFlights() {
		
			
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:file:manager/loty.db","sa","");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 resultSet = statement.executeQuery("SELECT * FROM LOTY");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.execute("SHUTDOWN");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return resultSet;
		
		
	
	}
}

