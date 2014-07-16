package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCustomer {

	public AddCustomer(String email, String firstName, String lastName,
			String password, int phone, String favorite) {

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

			ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

			while (rs.next()) {

				String emailCheck = rs.getString("email");

				if (emailCheck.equals(email)) {
					System.out.println("Customer existed");
					return;
				}

			}

			stmt.executeUpdate("INSERT INTO customers VALUES(" + "'" + email
					+ "'" + "," + "'" + firstName + "'" + "," + "'" + lastName
					+ "'" + "," + "'" + password + "'" + "," + "'"
					+ Integer.toString(phone) + "'" + "," + "'" + favorite
					+ "'" + ")");

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

}
