package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Books;

public class AddBook {

	public AddBook(String Isbn, String name, double price, int number) {

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB1";

		// Loading the Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		// Connecting to the server
		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM book");

			while (rs.next()) {

				String IsbnCheck = rs.getString("Isbn");

				if (IsbnCheck.equals(Isbn)) {
					
					int oldNumber = rs.getInt("number");
					int newNumber = oldNumber + number;
					
					stmt.executeUpdate("UPDATE book SET number = " + "'"
							+ Integer.toString(newNumber) + "'" + "WHERE Isbn = " + "'"
							+ IsbnCheck + "'");
					return;
				}

			}

			stmt.executeUpdate("INSERT INTO book VALUES(" + "'" + Isbn + "'"
					+ "," + "'" + name + "'" + "," + "'"
					+ Double.toString(price) + "'" + "," + "'"
					+ Integer.toString(number) + "'" + ")");

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

}
