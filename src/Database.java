import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {{

	
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:manager/loty.db","sa","");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM LOTY");
			statement.execute("SHUTDOWN");
			statement.close();
			
			while( resultSet.next() ) {
				System.out.println( resultSet.getString("DOKAD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}
	
}
