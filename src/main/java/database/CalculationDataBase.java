package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculationDataBase extends DataBase{
	
	/**
	 * Метод для тестирования новых функций.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws SQLException {
		
		String serverName = "DESKTOP-UGB9IJG";
		String dataBaseName = "Users";
		String user = "sa";
		String password = "123";
		
		UsersDataBase app = new UsersDataBase();
		Connection conn = app.connectToSQL(serverName,dataBaseName,user,password);
		
		Statement st = conn.createStatement();
		st.close();
	}
}
