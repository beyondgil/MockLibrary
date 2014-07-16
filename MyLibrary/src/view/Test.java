package view;

import java.awt.Color;

import javax.swing.JFrame;

public class Test extends JFrame{
	
	Test() {
		
		this.setTitle("Test");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(153, 204, 255));
		this.setResizable(false);
		
		this.add(new BookTable());
		
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Test();
	}

}
