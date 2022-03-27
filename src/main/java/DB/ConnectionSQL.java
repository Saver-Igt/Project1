package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQL {
	public static void main(String[] args) throws SQLException {
		/*
		 * "jdbc:sqlserver://DESKTOP-UGB9IJG;Database=Users;user=sa;password=123;"
		 *+"trustServerCertificate = true; encrypt = false; IntegratedSecurity = false";
		 * */
		String serverName = "DESKTOP-UGB9IJG";
		String dataBaseName = "Users";
		String user = "sa";
		String password = "123";
		
		ConnectionSQL app = new ConnectionSQL();
		Connection conn = app.connectToSQL(serverName,dataBaseName,user,password);
		
		Statement st = conn.createStatement();
		String sql = "INSERT INTO Users (name) VALUES ('')";
		st.executeUpdate(sql);
		st.close();
	}
	
	public Connection connectToSQL(String serverName,String dataBaseName, String user, String password) {
		String connectionURL =
			"jdbc:sqlserver://" + serverName  +";Database=" + dataBaseName 
			 +";user="+ user + ";password=" + password +";"
			 +"trustServerCertificate = true; encrypt = false; IntegratedSecurity = false";
		try {
			Connection con = DriverManager.getConnection(connectionURL);
			System.out.println("Connected to SQL");
			return con;		
		}catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;
	}

}
