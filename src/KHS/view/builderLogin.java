package KHS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import KHS.controller.FrontController;
import KHS.dto.AuthDTO;

public class builderLogin {

	//객체추가
	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPw;
	private final ButtonGroup rbtnGroup = new ButtonGroup();
	FrontController controller = new FrontController();
	
	public builderLogin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인창");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(96, 76, 116, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(96, 117, 116, 21);
		panel.add(txtPw);
		
		JLabel labelId = new JLabel("ID");
		labelId.setBounds(64, 79, 22, 15);
		panel.add(labelId);
		
		JLabel labelPw = new JLabel("PW");
		labelPw.setBounds(64, 120, 22, 15);
		panel.add(labelPw);
		
		JRadioButton rbtnEmp = new JRadioButton("직원");
		rbtnGroup.add(rbtnEmp);
		rbtnEmp.setBounds(176, 175, 74, 23);
		panel.add(rbtnEmp);
		
		JRadioButton rbtnMem = new JRadioButton("회원");
		rbtnMem.setSelected(true);
		rbtnGroup.add(rbtnMem);
		rbtnMem.setBounds(64, 175, 69, 23);
		panel.add(rbtnMem);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnEmp.isSelected())
				{
					AuthDTO dto = new AuthDTO(txtId.getText(),txtPw.getText());
					boolean r = controller.SubControllerEX("AUTH", 2, dto);
					if(r) {
						frame.setVisible(false);
						new builderEmployee();
					} else JOptionPane.showMessageDialog(null, "로그인 실패");
					
					
				//회원로그인
				}else if(rbtnMem.isSelected())
				{
					AuthDTO dto = new AuthDTO(txtId.getText(),txtPw.getText());
					boolean r = controller.SubControllerEX("AUTH", 1, dto);
					if(r) {
						frame.setVisible(false);
						new builderMember(txtId.getText());
					} else JOptionPane.showMessageDialog(null, "로그인 실패");
				}			
			}
		});		
		btnLogin.setBounds(284, 75, 97, 23);
		panel.add(btnLogin);
		
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
				System.out.println("종료버튼 누름!");
			}
		});
		btnExit.setBounds(284, 116, 97, 23);
		panel.add(btnExit);
		
		JButton btnSignup = new JButton("회원가입");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new builderSignUp();
			}
		});
		btnSignup.setBounds(284, 161, 97, 23);
		panel.add(btnSignup);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
