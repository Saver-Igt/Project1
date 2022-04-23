package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Класс баз данных.
 * Здесь находится общий для всех баз данных метод подключения к БД. 
 * @author Siraev
 * @version 1.0
 */
public class DataBase {
	protected Connection connection;
	protected Statement statement;
	/**
	 * Метод, осуществляющий подключение к БД.
	 *
	 * @param serverName имя сервера
	 * @param dataBaseName название БД
	 * @param user пользователь
	 * @param password пароль
	 * @return объект класса Connection
	 * @throws NamingException 
	 */
	public void connectToSQL() throws NamingException {
		InitialContext cxt = new InitialContext();
		DataSource dataSource = (DataSource) cxt.lookup("java:comp/env/jdbc/mssql-otzprod1");
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void createStatement() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Statement getStatement() {
		return statement;
	}
	public Connection getConnection() {
		return connection;
	}
}
