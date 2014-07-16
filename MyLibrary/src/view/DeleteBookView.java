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

import control.DeleteBook;

public class DeleteBookView extends JPanel implements ActionListener {

	JLabel JL[] = new JLabel[2];
	JTextField JT[] = new JTextField[2];
	JButton JB[] = new JButton[3];
	String labels[] = {"Isbn:", "Number:"};
	ImageIcon image1 = new ImageIcon("pic/delete.png");
	ImageIcon image2 = new ImageIcon("pic/cancel2.png");
	ImageIcon image3 = new ImageIcon("pic/reset.png");
	ImageIcon[] images = { image1, image2, image3 };

	DeleteBookView() {

		this.setLayout(null);
		this.setBackground(new Color(153, 204, 255));

		for (int i = 0; i < JL.length; i++) {
			JL[i] = new JLabel(labels[i]);
			JL[i].setSize(120, 50);
			JL[i].setLocation(250, 130 + i * 50);
			this.add(JL[i]);
		}

		for (int i = 0; i < JT.length; i++) {
			JT[i] = new JTextField();
			JT[i].setSize(200, 50);
			JT[i].setLocation(330, 130 + i * 50);
			this.add(JT[i]);
		}

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

			String Isbn = JT[0].getText().trim();
			int number = Integer.parseInt(JT[1].getText().trim());

			new DeleteBook(Isbn, number);

			JOptionPane.showMessageDialog(this, "Books have been deleted", "",
					JOptionPane.INFORMATION_MESSAGE);

		}

		if (e.getSource().equals(JB[1])) {
			if (!this.getParent().getComponent(0).isVisible()) {
				this.getParent().getComponent(0).setVisible(true);
				this.setVisible(false);
			}
		}

		if (e.getSource().equals(JB[2])) {
			for (int i = 0; i < JT.length; i++) {
				JT[i].setText("");
			}
		}

	}

}
