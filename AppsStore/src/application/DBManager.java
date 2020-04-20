package AppsStore.src.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager 
{
	private Connection con;
	public DBManager() throws ClassNotFoundException, SQLException
	{
		con = DriverManager.getConnection("jdbc:mysql://localhost/apps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "root");
	}
	
	public void close() throws SQLException
	{
		con.close();
	}
	
	public void ausgabeApps() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset");
		while(rs.next())
		{
			String App = rs.getString("App");
			String APP = App.replace("_"," ");
			System.out.printf("%s\n",APP);
			
		}
		rs.close();
		stmt.close();
	}
	
	public void ausgabe() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset");
		while (rs.next())
		{
			String App = rs.getString("App");
			String Category = rs.getString("Category");
			String Rating = rs.getString("Rating");
			String Reviews = rs.getString("Reviews");
			String Size = rs.getString("Size");
			String Installs = rs.getString("Installs");
			String Type_ = rs.getString("Type_");
			String Price = rs.getString("Price");
			String Content_Rating = rs.getString("Content_Rating");
			String Genres = rs.getString("Genres");
			String APP = App.replace("_"," ");
			String CATEGORY = Category.replace("_"," ");
			String SIZE = Size.replace("Varies with device", "/");
			String GENRES = Genres.replace("Video Players & Edit", "Videp Player");
			System.out.printf("|%-50s|%-20s|%5s|%7s|%6s|%6s|%5s|%7s|%-12s|%-18s|\n",APP,CATEGORY,Rating,Reviews,SIZE,Installs,Type_,Price,
																  Content_Rating,GENRES);
		}
		stmt.close();
		rs.close();
	}
}


