package application;

import java.sql.SQLException;

public class JDBC_Main
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		DBManager DB = new DBManager();
		DB.ausgabe();
		DB.close();
	}
}

