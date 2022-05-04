package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBase {
	protected Connection connection;
	protected Statement statement;
	public void connectToSQL() throws NamingException {
		InitialContext cxt = new InitialContext();
		DataSource dataSource = (DataSource) cxt.lookup("java:comp/env/jdbc/mssql-otzprod1");
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void connect() {
		String connectionUrl =
                "jdbc:sqlserver://88.99.186.187;"
                        + "database=Project1;"
                        + "user=sa;"
                        + "password=UgatuProject1;"
                        + "encrypt=false;"
                        + "trustServerCertificate=true;"
                        + "IntegratedSecurity=false;";
        try{
        	connection = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException e) {
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
	// Геттеры
	public Statement getStatement() {
		return statement;
	}
	public Connection getConnection() {
		return connection;
	}
}
