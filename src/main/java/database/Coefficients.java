package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coefficients extends DataBase{
	public float getPercentFromID() {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT Value FROM Users.dbo.Coefficient");
			while(resultSet.next()){
				return Float.parseFloat(resultSet.getString(1));
                }          
            }catch (SQLException e) {
            	e.printStackTrace();
            }
			return 0f;
	}
}
