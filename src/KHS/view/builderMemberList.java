package KHS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import KHS.controller.FrontController;
import KHS.dto.ListDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class builderMemberList {

	private JFrame frame;
	private String id;
	private String list_name;
	private JTextField textField;
	private JButton btnPlay;
	public static JTextArea txtList = new JTextArea();
	
	FrontController controller = new FrontController();
	
	

	public builderMemberList(String Member_Id, String List_Name) {
		
		id = Member_Id;
		list_name = List_Name;
		initialize();
	}
	
	

	private void initialize() {
		ListDTO dto = new ListDTO(id);
		boolean r = controller.SubControllerEX("LIST", 4, dto);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 811, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("[" + id + "]님의 ["+ list_name +"]" + "재생목록");
		lblWelcome.setBounds(12, 10, 411, 45);
		panel.add(lblWelcome);
		
		JLabel lblMusicCode = new JLabel("음악코드");
		lblMusicCode.setBounds(34, 320, 50, 15);
		panel.add(lblMusicCode);
		
		
		txtList.setBounds(22, 65, 683, 231);
		panel.add(txtList);
		
		textField = new JTextField();
		textField.setBounds(131, 317, 96, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		btnPlay = new JButton("재생");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PlayMusic buttonPressed = new PlayMusic("에스파-NextLevel.mp3", false); //한 번만 음악이 재생되도록 한다(false)
				buttonPressed.start();
			}
		});
		
		btnPlay.setBounds(313, 316, 91, 23);
		panel.add(btnPlay);
		frame.setVisible(true);
	}
}
