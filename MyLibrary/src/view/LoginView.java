package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.UserLogin;

public class LoginView extends JFrame implements ActionListener {

	JButton login, cancel;
	JLabel jl1, jl2;
	JTextField jt1, jt2;
	String s1, s2;

	LoginView() {
		this.setTitle("Login");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(153, 204, 255));
		this.setResizable(false);
		this.setLayout(null);

		login = new JButton();
		cancel = new JButton();
		login.setIcon(new ImageIcon("pic/login.png"));
		cancel.setIcon(new ImageIcon("pic/cancel.png"));
		login.setSize(120, 50);
		cancel.setSize(120, 50);
		login.setLocation(250, 300);
		cancel.setLocation(420, 300);
		login.addActionListener(this);
		cancel.addActionListener(this);

		jl1 = new JLabel("User ID:");
		jl2 = new JLabel("Password:");
		jl1.setSize(120, 50);
		jl2.setSize(120, 50);
		jl1.setLocation(250, 100);
		jl2.setLocation(250, 200);

		jt1 = new JTextField("");
		jt2 = new JTextField("");
		jt1.setSize(200, 50);
		jt2.setSize(200, 50);
		jt1.setLocation(340, 100);
		jt2.setLocation(340, 200);

		this.add(login);
		this.add(cancel);
		this.add(jl1);
		this.add(jl2);
		this.add(jt1);
		this.add(jt2);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		LoginView login = new LoginView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(login)) {
			s1 = jt1.getText();
			s2 = jt2.getText();
			if (s1.equals("admin") && s2.equals("admin")) {
				System.out.println("To admin");
			} else if (s1.equals("") || s2.equals("")) {
				System.out.println("Please fill in the user and passward");
			} else {
				new UserLogin(jt1.getText(), jt2.getText());
			}
		}
		if (e.getSource().equals(cancel)) {
			this.dispose();
		}
	}

}
