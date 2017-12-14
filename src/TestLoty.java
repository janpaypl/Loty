public class TestLoty{
	
public static void main(String[] args) {
	
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	//OknoLoty okno = new OknoLoty();
	Database database = new Database();
	
}

}
