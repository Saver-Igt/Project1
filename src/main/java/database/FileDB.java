package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FileDB extends DataBase{
	
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
		
		FileDB app = new FileDB();
		Connection conn = app.connectToSQL(serverName,dataBaseName,user,password);
		Statement st = conn.createStatement();
		ArrayList<String> ar= app.getAllFileName(st);
		ar.forEach((n) -> System.out.println(n));
		st.close();
	}
	public void insertFileInBase(Statement statement,String fileName,String date) {
		String insert = "INSERT INTO Files (FileName,Date) VALUES ('"+
				fileName + "', '" + date + "')";
		try {
			statement.executeUpdate(insert);
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getAllFileName(Statement statement) {
		ArrayList<String> array = new ArrayList<>();
		try {
			ResultSet resultSet = statement.executeQuery("SELECT FileName FROM Files");
			while(resultSet.next()){
				array.add(resultSet.getString(1));
                }          
            }catch (SQLException e) {
            	e.printStackTrace();
            }
			return array;
	}
	public void deleteFile(Statement statement,int id) {
		String sqlCommand = "DELETE FROM Files WHERE ID = " + Integer.toString(id);
		try {
			statement.executeUpdate(sqlCommand);
			System.out.println("File with id = " + id + " deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
