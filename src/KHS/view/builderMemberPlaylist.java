package KHS.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class builderMemberPlaylist {

	private JFrame frame;

	public builderMemberPlaylist() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 766, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 752, 436);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(55, 91, 482, 284);
		panel.add(formattedTextField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(603, 123, 91, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}
}
