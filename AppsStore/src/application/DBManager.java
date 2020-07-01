package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBManager {
	private Connection con;

	public DBManager() throws ClassNotFoundException, SQLException {
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost/apps?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "root");
	}

	public void close() throws SQLException {
		con.close();
	}

	public void ausgabeApps() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset");
		while (rs.next()) {
			String App = rs.getString("App");
			String APP = App.replace("_", " ");
			System.out.printf("%s\n", APP);

		}
		rs.close();
		stmt.close();
	}

	public void ausgabeCategorys() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DISTINCT Category from dataset;");
		while (rs.next()) {
			final String Category = rs.getString(2);
			final String CATEGORY = Category.replace("_", " ");
			System.out.printf("|%-50s|%-20s|%6s|%7s|%-18s|\n", CATEGORY);
		}
		stmt.close();
		rs.close();
	}

	public void ausgabe() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset");
		while (rs.next()) {
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
			String APP = App.replace("_", " ");
			String CATEGORY = Category.replace("_", " ");
			String SIZE = Size.replace("Varies with device", "/");
			String GENRES = Genres.replace("Video Players & Edit", "Videp Player");
			System.out.printf("|%-50s|%-20s|%5s|%7s|%6s|%6s|%5s|%7s|%-12s|%-18s|\n", APP, CATEGORY, Rating, Reviews,
					SIZE, Installs, Type_, Price, Content_Rating, GENRES);
		}
		stmt.close();
		rs.close();
	}

	public ObservableList<String> NameSearch(String s) throws SQLException {
		ObservableList<String> items = FXCollections.observableArrayList();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset WHERE App like '%" + s + "%';");
		while (rs.next()) {
			final String App = rs.getString(1);
			final String APP = App.replace("_", " ");

			items.add(APP);
		}
		//StringBuilder sb = new StringBuilder();
		//for (String a : items) {
		//	sb.append(a);
		//	sb.append("\n");
		//}
		//String a = sb.toString();
		stmt.close();
		rs.close();
		return items;
	}

	public void GenreSearch() throws SQLException {
		Scanner s = new Scanner(System.in);
		String S = s.next();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset WHERE Genres like '%" + S + "%'");
		while (rs.next()) {
			final String App = rs.getString(1);
			final String Category = rs.getString(2);
			final String Size = rs.getString(5);
			final String Price = rs.getString(8);
			final String Genres = rs.getString(10);
			final String APP = App.replace("_", " ");
			final String CATEGORY = Category.replace("_", " ");
			final String SIZE = Size.replace("Varies with device", "/");
			final String GENRES = Genres.replace("Video Players & Edit", "Videp Player");
			System.out.printf("|%-50s|%-20s|%6s|%7s|%-18s|\n", APP, CATEGORY, SIZE, Price, GENRES);
		}
		stmt.close();
		rs.close();
		s.close();
	}

	public void CategorySearch() throws SQLException {
		Scanner s = new Scanner(System.in);
		String S = s.next();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset WHERE Category like '%" + S + "%';");
		while (rs.next()) {
			final String App = rs.getString(1);
			final String Category = rs.getString(2);
			final String Size = rs.getString(5);
			final String Price = rs.getString(8);
			final String Genres = rs.getString(10);
			final String APP = App.replace("_", " ");
			final String CATEGORY = Category.replace("_", " ");
			final String SIZE = Size.replace("Varies with device", "/");
			final String GENRES = Genres.replace("Video Players & Edit", "Videp Player");
			System.out.printf("|%-50s|%-20s|%6s|%7s|%-18s|\n", APP, CATEGORY, SIZE, Price, GENRES);
		}
		stmt.close();
		rs.close();
		s.close();
	} 

	public void RatingSearch() throws SQLException {
		Scanner s = new Scanner(System.in);
		String S = s.next();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dataset WHERE Rating like '%" + S + "%';");
		while (rs.next()) {
			final String App = rs.getString(1);
			final String Category = rs.getString(2);
			final String Size = rs.getString(5);
			final String Price = rs.getString(8);
			final String Genres = rs.getString(10);
			final String APP = App.replace("_", " ");
			final String CATEGORY = Category.replace("_", " ");
			final String SIZE = Size.replace("Varies with device", "/");
			final String GENRES = Genres.replace("Video Players & Edit", "Videp Player");
			System.out.printf("|%-50s|%-20s|%6s|%7s|%-18s|\n", APP, CATEGORY, SIZE, Price, GENRES);
		}
		stmt.close();
		rs.close();
		s.close();
	}
	
	public String categ(String s) throws SQLException {
		String x = "";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT Category FROM dataset WHERE App ='" + s + "';");
		while (rs.next()) {
			final String Category = rs.getString(1);
			final String CATEGORY = Category.replace("_", " ");
			x = CATEGORY;
		}
		stmt.close();
		rs.close();
		return x;
	}
	
	public String size(String s) throws SQLException {
		String x = "";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT Size FROM dataset WHERE App ='" + s + "';");
		while (rs.next()) {
			final String Size = rs.getString(1);
			final String SIZE = Size.replace("Varies with device", "NaN");
			x = SIZE;
		}
		stmt.close();
		rs.close();
		return x;
	}
	
	public String rating(String s) throws SQLException {
		String x = "";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT Rating FROM dataset WHERE App ='" + s + "';");
		while (rs.next()) {
			final String Rating = rs.getString(1);
			x = Rating;
		}
		stmt.close();
		rs.close();
		return x;
	}
	
	public ObservableList<String> Categorys() throws SQLException {
		ObservableList<String> items = FXCollections.observableArrayList();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DISTINCT Category FROM dataset");
		while (rs.next()) {
			final String cat = rs.getString(1);
			final String CAT = cat.replace("_", " ");
			items.add(CAT);
		}
		stmt.close();
		rs.close();
		return items;
	}
	
	public ObservableList<String> CatApps(String s) throws SQLException {
		ObservableList<String> items = FXCollections.observableArrayList();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT App FROM dataset WHERE Category ='" + s + "';");
		while (rs.next()) {
			final String App = rs.getString(1);
			final String APP= App.replace("_", " ");
			items.add(APP);
		}
		stmt.close();
		rs.close();
		return items;
	}
}
