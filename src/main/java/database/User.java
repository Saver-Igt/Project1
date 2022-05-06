package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Класс для управления базой данных пользователей.
 * @author Siraev
 * @version 2.0
 */
public class User extends DataBase{
	
	/** Родь по умолчанию. */
	private ROLE role = User.ROLE.UNKNOWN;
	
	/**
	 * Метод, добавляющий нового пользователя.
	 * По умолчанию добавляет простого пользователя.
	 *
	 * @param login логин нового пользователя
	 * @param password пароль
	 */
	public void insertInBase(String login,String password) {
		String md5Hex = DigestUtils.md5Hex("salt" + password);
		String insert = "INSERT INTO Project1.dbo.Users (login,password,Role) VALUES ('"+
				login + "', '" + md5Hex + "', 'USER')";
		try {
			statement.executeUpdate(insert);
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Метод, проверяющий уникальность логина.
	 *
	 * @param login логин для проверки
	 * @return true, если логин уже есть в базе
	 */
	public boolean checkForUniqueLogin(String login) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Project1.dbo.Users");
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
	 * @param login логин
	 * @return ID пользователя
	 */
	public int getID(String login) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Project1.dbo.Users");
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
	 * @param login логин на проверку
	 * @param password пароль на проверку
	 * @return true, если авторизация прошла успешно
	 */
	public boolean userIsExist(String login,String password) {
		String md5Hex = DigestUtils.md5Hex("salt" + password);
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Project1.dbo.Users");
			while(resultSet.next()){
                if(login.equals(resultSet.getString(2)) && md5Hex.equals(resultSet.getString(3))) {
                	return true;
                }          
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Enum со всеми возможными ролями.
	 */
	public enum ROLE {
        /** обычный пользователь. */
        USER, 
		/** Суперпользователь. */
		ADMIN, 
		/** Не авторезированный пользователь. */
		UNKNOWN
    }
	
	/**
	 * Геттер для роли.
	 *
	 * @return the role
	 */
	public ROLE getRole() {
        return role;
    }

    /**
     * Сеттер для роли
     *
     * @param role the new role
     */
    public void setRole(ROLE role) {
        this.role = role;
    }
    
    /**
     * Преобразование строки в роль.
     *
     * @param str строка с ролью
     */
    public void setRoleFromString(String str) {
    	if(str.equals("ADMIN")) {
    		role = ROLE.ADMIN;
    	}else if (str.equals("USER")) {
    		this.role = ROLE.USER;
    	}else {
    		this.role = ROLE.UNKNOWN;
    	}
    }
    
    /**
     * Задание роли по ID
     *
     * @param id
     */
    public void setRoleFromID(int id) {
    	ResultSet resultSet;
		try {
			resultSet = statement.executeQuery("SELECT Role FROM Project1.dbo.Users Where ID = " + id);
			while(resultSet.next()){
				setRoleFromString(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
