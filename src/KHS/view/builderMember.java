package KHS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import KHS.controller.FrontController;
import KHS.dto.ListDTO;
import javax.swing.JTextField;

public class builderMember {

	private JFrame frame;
	
	public String txtId;
	public static JTextArea textArea = new JTextArea();
	
	FrontController controller = new FrontController();
	private JTextField txtListName;
	private JTextField txtMusicCode;
	private JTextField txtName;
	
	public builderMember(String txtId) {
		this.txtId = txtId;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel(txtId+"님 환영합니다.");
		lblId.setBounds(47, 30, 205, 15);
		panel.add(lblId);
		
		JLabel lblMusicCode = new JLabel("음악코드");
		lblMusicCode.setBounds(60, 448, 57, 15);
		panel.add(lblMusicCode);
		textArea.setEnabled(false);
		textArea.setText("전체재생목록");
		
		
		textArea.setBounds(47, 89, 559, 122);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEnabled(false);
		textArea_1.setBounds(47, 271, 559, 139);
		panel.add(textArea_1);
		
		JButton btnSelect = new JButton("내 전체 재생목록조회");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("전체조회 버튼 누름!");
				ListDTO dto = new ListDTO(txtId);
				boolean r = controller.SubControllerEX("LIST", 1, dto);
				if(r) {System.out.println("전체조회 성공 ^^");}
				else {System.out.println("전체조회 실패 ㅋ");}				
				
			}
		});
		
		txtListName = new JTextField();
		txtListName.setBounds(161, 240, 116, 21);
		panel.add(txtListName);
		txtListName.setColumns(10);
		
		txtMusicCode = new JTextField();
		txtMusicCode.setBounds(168, 442, 116, 21);
		panel.add(txtMusicCode);
		txtMusicCode.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(148, 55, 116, 21);
		panel.add(txtName);
		txtName.setColumns(10);
		btnSelect.setBounds(430, 46, 176, 33);
		panel.add(btnSelect);
		
		JButton btnSelect_1 = new JButton("재생목록 내부조회");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect_1.setBounds(389, 228, 176, 33);
		panel.add(btnSelect_1);
		
		JButton btnAdd = new JButton("재생목록추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("재생목록 추가 버튼 누름!");
				ListDTO dto = new ListDTO(txtName.getText(),txtId,txtId + "_" + txtName.getText(),null);
				boolean r = controller.SubControllerEX("LIST", 2, dto);
				if(r) {System.out.println("추가 성공 ^^");}
				else {System.out.println("추가 실패 ㅋ");}	
				
			}
		});
		btnAdd.setBounds(277, 45, 116, 34);
		panel.add(btnAdd);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(296, 444, 97, 23);
		panel.add(btnNewButton);
		
		JLabel lblListName = new JLabel("재생목록이름");
		lblListName.setBounds(52, 246, 97, 15);
		panel.add(lblListName);
		
		JButton btnSelect_1_1 = new JButton("재생!");
		btnSelect_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect_1_1.setBounds(389, 439, 176, 33);
		panel.add(btnSelect_1_1);
		
		JLabel lblListName_1 = new JLabel("재생목록이름");
		lblListName_1.setBounds(57, 55, 97, 15);
		panel.add(lblListName_1);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
