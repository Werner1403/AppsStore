package application;

import java.sql.SQLException;
/**
 * 
 * @author werne
 * @deprecated
 */
public class JDBC_Main
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		DBManager DB = new DBManager();
		DB.ausgabeCategorys();
		DB.close();
	}
}

