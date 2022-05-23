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
		
		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblId = new JLabel(txtId+"님 환영합니다.");
		lblId.setBounds(47, 30, 205, 15);
		panel1.add(lblId);
		
		ListDTO dto = new ListDTO(txtId);
		boolean r = controller.SubControllerEX("LIST", 1, dto);
		
		
		textArea.setBounds(47, 100, 383, 122);
		panel1.add(textArea);
		
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
		
		txtName = new JTextField();
		txtName.setBounds(47, 268, 161, 27);
		panel1.add(txtName);
		txtName.setColumns(10);
		btnSelect.setBounds(47, 57, 176, 33);
		panel1.add(btnSelect);
		
		JButton btnSelectInside = new JButton("재생목록 내부조회");
		btnSelectInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new builderMemberList(txtId, txtName.getText());
			}
		});
		btnSelectInside.setBounds(242, 352, 176, 33);
		panel1.add(btnSelectInside);
		
		JButton btnAdd = new JButton("재생목록추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("재생목록 추가 버튼 누름!");
				ListDTO dto = new ListDTO(txtName.getText(),txtId,null);
				boolean r = controller.SubControllerEX("LIST", 2, dto);
				if(r) {System.out.println("추가 성공 ^^");}
				else {System.out.println("추가 실패 ㅋ");}	
				
			}
		});
		btnAdd.setBounds(242, 264, 176, 34);
		panel1.add(btnAdd);
		
		JLabel lblListName_1 = new JLabel("재생목록이름");
		lblListName_1.setBounds(47, 243, 97, 15);
		panel1.add(lblListName_1);
		
		JButton btnDelete = new JButton("재생목록 삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("재생목록 삭제 버튼 누름!");
					ListDTO dto = new ListDTO(txtName.getText(),txtId);
					boolean r = controller.SubControllerEX("LIST", 3, dto);
					if(r) {System.out.println("삭제 성공 ^^");}
					else {System.out.println("삭제 실패 ㅋ");}	
			}
		});
		btnDelete.setBounds(242, 309, 176, 33);
		panel1.add(btnDelete);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
