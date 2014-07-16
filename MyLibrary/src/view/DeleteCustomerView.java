package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.DeleteCustomer;

public class DeleteCustomerView extends JPanel implements ActionListener {

	JLabel JL = new JLabel();
	JTextField JT = new JTextField();
	JButton JB[] = new JButton[3];
	ImageIcon image1 = new ImageIcon("pic/delete.png");
	ImageIcon image2 = new ImageIcon("pic/cancel2.png");
	ImageIcon image3 = new ImageIcon("pic/reset.png");
	ImageIcon[] images = { image1, image2, image3 };

	DeleteCustomerView() {

		this.setLayout(null);
		this.setBackground(new Color(153, 204, 255));

		JL.setText("Email:");
		JL.setSize(120, 50);
		JL.setLocation(250, 150);
		this.add(JL);

		JT.setSize(200, 50);
		JT.setLocation(330, 150);
		this.add(JT);

		for (int j = 0; j < JB.length; j++) {
			JB[j] = new JButton();
			JB[j].setIcon(images[j]);
			JB[j].setSize(120, 50);
			JB[j].setLocation(140 + 200 * j, 350);
			this.add(JB[j]);
			JB[j].addActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(JB[0])) {

			String email = JT.getText().trim();

			new DeleteCustomer(email);

			JOptionPane.showMessageDialog(this, "Customer has been deleted",
					"", JOptionPane.INFORMATION_MESSAGE);

		}

		if (e.getSource().equals(JB[1])) {
			if (!this.getParent().getComponent(0).isVisible()) {
				this.getParent().getComponent(0).setVisible(true);
				this.setVisible(false);
			}
		}

		if (e.getSource().equals(JB[2])) {
			JT.setText("");
		}

	}

}
