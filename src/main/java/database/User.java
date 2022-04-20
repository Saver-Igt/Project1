package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс для управления базой данных пользователей.
 * @author Siraev
 * @version 1.1
 */
public class User extends DataBase{
	private ROLE role = User.ROLE.UNKNOWN;
	
	/**
	 * Метод, добавляющий нового пользователя.
	 * По умолчанию добавляет простого пользователя.
	 * @param statement объект, выполняющий команды SQL
	 * @param login логин нового пользователя
	 * @param password пароль
	 */
	public void insertInBase(String login,String password) {
		String insert = "INSERT INTO DataBase.dbo.Users (login,password,Role) VALUES ('"+
				login + "', '" + password + "', 'USER')";
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
	public void updateData(String login,String password, String userClass,int id) {
		String sqlCommand = "UPDATE DataBase.dbo.Users SET login = '" + login +"',"
				+ "password ='"+ password+"',"
				+ "Role = '" + userClass+ "' WHERE ID = " + Integer.toString(id);
		try {
			statement.executeUpdate(sqlCommand);
			System.out.println("Data updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Метод удаляет пользователя по ID.
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param id ID пользователя
	 */
	public void deleteUser(int id) {
		String sqlCommand = "DELETE FROM DataBase.dbo.Users WHERE ID = " + Integer.toString(id);
		try {
			statement.executeUpdate(sqlCommand);
			System.out.println("User with id = " + id + " deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Метод, проверяющий уникальность логина.
	 *
	 * @param statement объект, выполняющий команды SQL
	 * @param login логин для проверки
	 * @return true, если логин уже есть в базе
	 */
	public boolean checkForUniqueLogin(String login) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DataBase.dbo.Users");
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
	public int getID(String login) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DataBase.dbo.Users");
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
	public boolean userIsExist(String login,String password) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DataBase.dbo.Users");
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
	public void setRoleFromLoginPassword(String login,String password) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM DataBase.dbo.Users");
			while(resultSet.next()){
                if(login.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {
                	setRoleFromString(resultSet.getString(4));
                }          
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public enum ROLE {
        USER, ADMIN, UNKNOWN
    }
	public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
    public void setRoleFromString(String str) {
    	if(str.equals("ADMIN")) {
    		role = ROLE.ADMIN;
    	}else if (str.equals("USER")) {
    		this.role = ROLE.USER;
    	}else {
    		this.role = ROLE.UNKNOWN;
    	}
    }
    public void setRoleFromID(int id) {
    	ResultSet resultSet;
		try {
			resultSet = statement.executeQuery("SELECT Role FROM DataBase.dbo.Users Where ID = " + id);
			while(resultSet.next()){
				setRoleFromString(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
