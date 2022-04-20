package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coefficients extends DataBase{
	public float getPercentFromID(int ID) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT Value FROM DataBase.dbo.Coefficient WHERE ID = "+ ID);
			while(resultSet.next()){
				return Float.parseFloat(resultSet.getString(1));
                }          
            }catch (SQLException e) {
            	e.printStackTrace();
            }
			return 0f;
	}
	public void setPercentFromID(float value, int ID) {
		String sqlCommand = "UPDATE DataBase.dbo.Coefficient SET Value = " + value +
				"WHERE ID = " + ID;
		try {
			statement.executeUpdate(sqlCommand);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
