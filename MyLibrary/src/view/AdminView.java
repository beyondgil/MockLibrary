package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AdminView extends JFrame implements ActionListener {

	JPanel firstPanel = new JPanel();
	JPanel secondPanel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane();

	JButton addCustomer = new JButton();
	JButton deleteCustomer = new JButton();
	JButton addBook = new JButton();
	JButton deleteBook = new JButton();

	AdminView() {
		this.setTitle("Admin");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(153, 204, 255));
		this.setResizable(false);
		firstPanel.setBackground(new Color(153, 204, 255));
		secondPanel.setBackground(new Color(153, 204, 255));

		firstPanel.setLayout(null);
		addCustomer.setSize(250, 50);
		deleteCustomer.setSize(250, 50);
		addCustomer.setLocation(110, 330);
		deleteCustomer.setLocation(420, 330);
		addCustomer.setIcon(new ImageIcon("pic/addcustomer.png"));
		deleteCustomer.setIcon(new ImageIcon("pic/deletecustomer.png"));
		firstPanel.add(addCustomer);
		firstPanel.add(deleteCustomer);
		
		CustomerTable ct = new CustomerTable();
		ct.setSize(730, 280);
		ct.setLocation(25, 0);
		firstPanel.add(ct);

		secondPanel.setLayout(null);
		addBook.setSize(250, 50);
		deleteBook.setSize(250, 50);
		addBook.setLocation(110, 330);
		deleteBook.setLocation(420, 330);
		addBook.setIcon(new ImageIcon("pic/addbook.png"));
		deleteBook.setIcon(new ImageIcon("pic/deletebook.png"));
		secondPanel.add(addBook);
		secondPanel.add(deleteBook);
		
		BookTable bt = new BookTable();
		bt.setSize(730, 280);
		bt.setLocation(25, 0);
		secondPanel.add(bt);

		addCustomer.addActionListener(this);
		deleteCustomer.addActionListener(this);

		addBook.addActionListener(this);
		deleteBook.addActionListener(this);

		tabbedPane.add("Customer", firstPanel);
		tabbedPane.add("    Book    ", secondPanel);
		this.add(tabbedPane);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		AdminView admin = new AdminView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(addBook)) {
			tabbedPane.setVisible(false);
			AddBookView ab = new AddBookView();
			this.add(ab);
		}

		if (e.getSource().equals(deleteBook)) {
			tabbedPane.setVisible(false);
			DeleteBookView db = new DeleteBookView();
			this.add(db);
		}

		if (e.getSource().equals(addCustomer)) {
			tabbedPane.setVisible(false);
			AddCustomerView ac = new AddCustomerView();
			this.add(ac);
		}

		if (e.getSource().equals(deleteCustomer)) {
			tabbedPane.setVisible(false);
			DeleteCustomerView dc = new DeleteCustomerView();
			this.add(dc);
		}

	}

}
