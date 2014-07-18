package view;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerTable extends JPanel {

	Object[][] allCustomer = new Object[1000][6];
	String[] columnNames = { "Email", "FirstName", "LastName", "Password",
			"Phone", "Favorite" };

	JTable customerTable;

	public CustomerTable() {

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

			int i = 0;

			while (rs.next()) {

				allCustomer[i][0] = rs.getString("email");
				allCustomer[i][1] = rs.getString("firstName");
				allCustomer[i][2] = rs.getString("lastName");
				allCustomer[i][3] = rs.getString("password");
				allCustomer[i][4] = rs.getString("phone");
				allCustomer[i][5] = rs.getString("favorite");

				i++;

			}

			customerTable = new JTable(allCustomer, columnNames);
			//customerTable.setGridColor(Color.BLACK);
			customerTable.setPreferredScrollableViewportSize(new Dimension(700, 250));
			customerTable.setFillsViewportHeight(true);
			
			JScrollPane scrollPane = new JScrollPane(customerTable);
			this.add(scrollPane);

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}
}
