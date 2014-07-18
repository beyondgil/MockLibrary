package view;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BookTable extends JPanel {

	Object[][] allBooks = new Object[1000][4];
	String[] columnNames = { "Isbn", "Name", "Price", "Number" };

	JTable bookTable;

	public BookTable() {

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

			int i = 0;

			while (rs.next()) {

				allBooks[i][0] = rs.getString("Isbn");
				allBooks[i][1] = rs.getString("name");
				allBooks[i][2] = rs.getString("price");
				allBooks[i][3] = rs.getString("number");

				i++;

			}

			bookTable = new JTable(allBooks, columnNames);
			// bookTable.setGridColor(Color.BLACK);
			bookTable
					.setPreferredScrollableViewportSize(new Dimension(700, 250));
			bookTable.setFillsViewportHeight(true);

			JScrollPane scrollPane = new JScrollPane(bookTable);
			this.add(scrollPane);

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

}
