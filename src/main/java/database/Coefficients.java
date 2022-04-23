package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coefficients extends DataBase{
	public float getPercentFromName(String name) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Project1.dbo.Coefficients WHERE Name ='" +name+ "'");
			while(resultSet.next()){
				return Float.parseFloat(resultSet.getString(2));
                }          
            }catch (SQLException e) {
            	e.printStackTrace();
            }
			return 0f;
	}
	public void setPercentFromName(float value, String name) {
		String sqlCommand = "UPDATE Project1.dbo.Coefficients SET Value = " + value +
				"WHERE Name = '" + name + "'";
		try {
			statement.executeUpdate(sqlCommand);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
