package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class UserLogin {

	public UserLogin(String jt1, String jt2) {

		String s1 = jt1;
		String s2 = jt2;

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

			// get query result to ResultSet rs
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

			List<Customer> customers = new ArrayList<Customer>();

			while (rs.next()) {

				String Id = rs.getString("email");
				String password = rs.getString("password");

				if (s1.equals(Id) && s2.equals(password)) {
					System.out.println("To Customer");
					return;
				}

			}

			System.out.println("Do not find such customer");

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

}
