import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBReader {
	
	public Object[][] readDataFromDB() throws Exception{
		Object array[][]=new Object[3][2];
		// Load the Driver 
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
		// Step -2 Making the DataBase Connection
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port/dbname");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
		// Step -3 Do Query to the DataBase
		Statement stmt = con.createStatement();
		// Step - 4 Store the Query result (Records) in ResultSet
		ResultSet rs = stmt.executeQuery("select userid,pwd from userdata ");
		// Step -5 Traverse the Records
		int rowNumber =  0;
		while(rs.next()){
			array[rowNumber][0] = rs.getString("userid");
			array[rowNumber][1] = rs.getString("pwd");
			rowNumber++;
		}
		rs.close();
		stmt.close();
		con.close();
		return array;
	}

}
