package KHS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import KHS.controller.FrontController;
import KHS.dto.AuthDTO;
import javax.swing.JPasswordField;

public class builderSignUp {

	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPw;
	
	//객체들..
	FrontController controller = new FrontController();


	public builderSignUp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(43, 64, 50, 15);
		panel.add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(43, 105, 50, 15);
		panel.add(lblPw);
		
		txtId = new JTextField();
		txtId.setBounds(114, 61, 96, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JPasswordField();
		txtPw.setColumns(10);
		txtPw.setBounds(114, 102, 96, 21);
		panel.add(txtPw);
		
		JButton btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthDTO dto = new AuthDTO(txtId.getText(),txtPw.getText());
	    		boolean r = controller.SubControllerEX("AUTH", 3, dto);
	    		if(r) {
	    			txtId.setText(""); txtPw.setText("");
	    			JOptionPane.showMessageDialog(null, "회원가입 성공");
	    		}else{
	    			JOptionPane.showMessageDialog(null, "회원가입 실패");
	    		}
				
				
			}
		});
		btnInsert.setBounds(294, 60, 91, 23);
		panel.add(btnInsert);
		
		JButton btnLogin = new JButton("로그인하러 가기");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new builderLogin();
			}
		});
		btnLogin.setBounds(253, 105, 132, 23);
		panel.add(btnLogin);
		frame.setVisible(true);
	}
}
