package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс для управления базой данных пользователей.
 * @author Siraev
 * @version 1.0
 */
public class UsersDataBase {
	
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
			Connection con = DriverManager.getConnection(connectionURL);
			System.out.println("Connected to SQL");
			return con;		
		}catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Метод, добавляющий нового пользователя.
	 * По умолчанию добавляет простого пользователя.
	 * @param statement объект, выполняющий команды SQL
	 * @param login логин нового пользователя
	 * @param password пароль
	 */
	public void insertInBase(Statement statement,String login,String password) {
		String insert = "INSERT INTO Users (login,password,ClassUSer) VALUES ('"+
				login + "', '" + password + "', 'SimpleUser')";
		try {
			statement.executeUpdate(insert);
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Метод, изменяющий данные пользователя.
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param login новый логин
	 * @param password новый парволь
	 * @param userClass новый класс пользователя(для админа)
	 * @param id ID, по которому происходит изменение
	 */
	public void updateData(Statement statement,String login,String password, String userClass,int id) {
		String sqlCommand = "UPDATE Users SET login = '" + login +"',"
				+ "password ='"+ password+"',"
				+ "Classuser = '" + userClass+ "' WHERE ID = " + Integer.toString(id);
		try {
			statement.executeUpdate(sqlCommand);
			System.out.println("Data updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Метод удаляет пользователя по ID
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param id ID пользователя
	 */
	public void deleteUser(Statement statement,int id) {
		String sqlCommand = "DELETE FROM Users WHERE ID = " + Integer.toString(id);
		try {
			statement.executeUpdate(sqlCommand);
			System.out.println("User with id = " + id + " deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Метод, проверяющий уникальность логина
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param login логин для проверки
	 * @return true, если логин уже есть в базе
	 */
	public boolean checkForUniqueLogin(Statement statement,String login) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
			while(resultSet.next()){
                if(login.equals(resultSet.getString(2))) {
                	return true;
                }          
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Метод для получения ID по логину.
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param login логин
	 * @return ID пользователя
	 */
	public int getID(Statement statement,String login) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
			while(resultSet.next()){
                if(login.equals(resultSet.getString(2))) {
                	return resultSet.getInt(1);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Метод для авторизации пользователя.
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param login логин на проверку
	 * @param password пароль на проверку
	 * @return true, если авторизация прошла успешно
	 */
	public boolean checkForUser(Statement statement,String login,String password) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
			while(resultSet.next()){
                if(login.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {
                	return true;
                }          
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
