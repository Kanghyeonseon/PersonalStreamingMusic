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

public class builderMember {

	private JFrame frame;
	
	public String txtId;
	public static JTextArea textArea = new JTextArea();
	
	FrontController controller = new FrontController();
	
	public builderMember(String txtId) {
		this.txtId = txtId;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel(txtId+"님 환영합니다.");
		lblId.setBounds(47, 30, 205, 15);
		panel.add(lblId);
		textArea.setText("전체재생목록");
		
		
		textArea.setBounds(68, 85, 518, 249);
		panel.add(textArea);
		
		JButton btnSelect = new JButton("전체 재생목록조회");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("전체조회 버튼 누름!");
				ListDTO dto = new ListDTO(txtId);
				boolean r = controller.SubControllerEX("LIST", 1, dto);
				if(r) {System.out.println("전체조회 성공 ^^");}
				else {System.out.println("전체조회 실패 ㅋ");}
				
				
				
			}
		});
		btnSelect.setBounds(466, 21, 176, 33);
		panel.add(btnSelect);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
