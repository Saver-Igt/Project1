package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс баз данных.
 * Здесь находится общий для всех баз данных метод подключения к БД. 
 * @author Siraev
 * @version 1.0
 */
public class DataBase {

	/**
	 * Метод, осуществляющий подключение к БД.
	 *
	 * @param serverName имя сервера
	 * @param dataBaseName название БД
	 * @param user пользователь
	 * @param password пароль
	 * @return объект класса Connection
	 */
	public Connection connectToSQL(String serverName,String dataBaseName, String user, String password) {
		String connectionURL =
			"jdbc:sqlserver://" + serverName  +";Database=" + dataBaseName 
			 +";user="+ user + ";password=" + password +";"
			 +"trustServerCertificate = true; encrypt = false; IntegratedSecurity = false";
		try {
			Connection con = (Connection) DriverManager.getConnection(connectionURL);
			System.out.println("Connected to SQL");
			return con;		
		}catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;
	}
}
