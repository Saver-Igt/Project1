package database;

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
	
	public void insertFileInBase(Statement statement,String fileName,String date) {
		String insert = "INSERT INTO Users.dbo.Files (FileName,Date) VALUES ('"+
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
			ResultSet resultSet = statement.executeQuery("SELECT FileName FROM Users.dbo.Files");
			while(resultSet.next()){
				array.add(resultSet.getString(1));
                }          
            }catch (SQLException e) {
            	e.printStackTrace();
            }
			return array;
	}
	public void deleteFile(Statement statement,int id) {
		String sqlCommand = "DELETE FROM Users.dbo.Files WHERE ID = " + Integer.toString(id);
		try {
			statement.executeUpdate(sqlCommand);
			System.out.println("File with id = " + id + " deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
