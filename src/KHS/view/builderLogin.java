package KHS.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import KHS.main.Main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class builderLogin extends JFrame{

	//객체추가
	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPw;
	private final ButtonGroup rbtnGroup = new ButtonGroup();
	FrontController controller = new FrontController();
	
	JLabel logoImage = new JLabel();
	
	
	
	public builderLogin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("로그인창");
		frame.setBounds(100, 100, 442, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon logoIcon = new ImageIcon(Main.class.getResource("../../images/로고.jpg"));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 426, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rbtnEmp = new JRadioButton("직원");
		rbtnEmp.setBackground(Color.WHITE);
		rbtnGroup.add(rbtnEmp);
		rbtnEmp.setBounds(247, 490, 74, 23);
		panel.add(rbtnEmp);
		
		JRadioButton rbtnMem = new JRadioButton("회원");
		rbtnMem.setBackground(Color.WHITE);
		rbtnMem.setSelected(true);
		rbtnGroup.add(rbtnMem);
		rbtnMem.setBounds(121, 490, 69, 23);
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
		
		txtPw = new JPasswordField();
		txtPw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
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
			}
		});
		
		txtId = new JTextField();
		txtId.setBounds(79, 376, 272, 42);
		panel.add(txtId);
		txtId.setColumns(10);
		txtPw.setBounds(79, 428, 272, 42);
		panel.add(txtPw);
		btnLogin.setBounds(79, 529, 272, 42);
		panel.add(btnLogin);
		
		JButton btnSignup = new JButton("회원가입");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new builderSignUp();
			}
		});
		btnSignup.setBounds(79, 581, 272, 42);
		panel.add(btnSignup);
		logoImage.setBounds(55, 31, 323, 308);
		panel.add(logoImage);
		logoImage.setIcon(logoIcon);
		logoImage.setHorizontalAlignment(JLabel.CENTER);
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); //창 크기를 변환시킬 수 없게 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	} //initialize 메소드 끝
	



	
	
	
	
}
