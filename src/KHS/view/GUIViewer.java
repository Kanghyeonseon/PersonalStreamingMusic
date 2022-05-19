package KHS.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import KHS.controller.FrontController;
import KHS.domain.DAO;
import KHS.domain.MusicDAO;
import KHS.dto.AuthDTO;
import KHS.dto.DTO;
import KHS.dto.MusicDTO;

public class GUIViewer extends JFrame implements ActionListener,KeyListener,MouseListener {
	//생성자
	public GUIViewer()	{
		super();
		Login();
		System.out.println("로그인 창 생성!");
	}
	
	//컨트롤러 추가
	FrontController controller =new FrontController();
	
	//기본폰트
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	Font fontBold = new Font("맑은 고딕", Font.BOLD, 12);

	
	//로그인메뉴
	JFrame loginMenu = new JFrame("로그인창"); 
	JTextField txtLoginId, txtLoginPw; 
	JButton btnLogin, btnExit; 
	JRadioButton rbtnEmp, rbtnMem; ButtonGroup radiogroup;
	JLabel labelEmp, labelMem;
	
	void Login() {
		loginMenu = new JFrame("로그인창");
		
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		txtLoginId = new JTextField("아이디를 입력하세요");
		txtLoginPw = new JPasswordField("비밀번호를 입력하세요"); 
		
		txtLoginId.addKeyListener(this);
		txtLoginId.setFocusTraversalKeysEnabled(false);
		
		btnLogin  = new JButton("로그인");
		btnExit   = new JButton("종료");
		signup = new JButton("회원가입");
		
		labelEmp = new JLabel("직원");
		labelMem = new JLabel("멤버");
		
		rbtnEmp = new JRadioButton("직원");
		rbtnMem   = new JRadioButton("회원");
		
		radiogroup = new ButtonGroup();
		radiogroup.add(rbtnEmp);
		radiogroup.add(rbtnMem);
		
		btnLogin.setFont(font);
		btnExit.setFont(font);
		signup.setFont(font);
		labelEmp.setFont(font);
		labelMem.setFont(font);
		
		txtLoginId.setBounds(20,30,200,30);
		txtLoginPw.setBounds(20,70,200,30);
		btnLogin.setBounds(230,30,80,70);
		btnExit.setBounds(320,30,80,70);
		signup.setBounds(230,110,170,30);
		
		rbtnEmp.setBounds(30,115,20,20);
		labelEmp.setBounds(55,115,40,20);
		rbtnMem.setBounds(130,115,20,20);
		labelMem.setBounds(155,115,40,20);
		
		
		rbtnEmp.setSelected(true);
		
		//리스너
		txtLoginId.addMouseListener(this);
		txtLoginPw.addMouseListener(this);
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		signup.addActionListener(this);		
		
		pan.add(txtLoginId);
		pan.add(txtLoginPw);
		pan.add(btnLogin);
		pan.add(btnExit);
		pan.add(labelEmp);
		pan.add(labelMem);
		pan.add(rbtnEmp);
		pan.add(rbtnMem);
		pan.add(signup);
		
		loginMenu.add(pan);		
		
		loginMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginMenu.setBounds(500,500,450,200);
		loginMenu.setVisible(true);
	}
	
	
	//회원가입	
	JTextField txtSignId, txtSignPw;
	JLabel labelSignId, labelSignPw;
	JButton btnSignInput;
	JFrame signupmenu;
	void SignUp() {
		signupmenu = new JFrame("회원가입");
		JPanel pan2 = new JPanel();
		pan2.setLayout(null);
		
		
		JLabel labelSignNotice = new JLabel("가입하실 아이디와 비밀번호를 입력해주세요.");
		
		
		labelSignId = new JLabel("ID");
		labelSignPw = new JLabel("PW");
		
		txtSignId = new JTextField();
		txtSignPw = new JTextField();
	   
		btnSignInput = new JButton("정보입력");
	 
		labelSignNotice.setBounds(35, 10, 300, 30);
		txtSignId.setBounds(35,40,200,30);
		labelSignId.setBounds(10,40,200,30);
		labelSignPw.setBounds(10,80,200,30);
		txtSignPw.setBounds(35,80,200,30);
		btnSignInput.setBounds(250,40,110,70);
		
		labelSignNotice.setFont(new Font("맑은 고딕", Font.PLAIN , 12));
		labelSignId.setFont(new Font("맑은 고딕", Font.BOLD , 12));
		labelSignPw.setFont(new Font("맑은 고딕", Font.BOLD , 12));
		btnSignInput.setFont(new Font("맑은 고딕", Font.BOLD , 12));
		
	   
		btnSignInput.addActionListener(this);

		
	   
		pan2.add(labelSignNotice);
		pan2.add(labelSignId);
		pan2.add(txtSignId);	   
		pan2.add(labelSignPw);	   
		pan2.add(txtSignPw);
		pan2.add(btnSignInput);
	   
		signupmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signupmenu.setBounds(100,100,400,170);
		signupmenu.add(pan2);
		signupmenu.setVisible(true);
	}
	
	//직원 메뉴 관련 
	JFrame employeemenu; 
	JButton insert;
	JButton update;
	JButton delete;
	JButton select;
	JButton signup;
	JTextArea area;
	JScrollPane scroll;
	JButton bt1; JButton bt2; JButton bt3; JButton bt4; JButton bt5; //전체음악보기, 음악추가, 음악수정, 음악삭제, 종료
	JButton bt6;
	public JTextField area1; JTextField area2; JTextField area3; JTextField area4; JTextField area5; JTextField area6;
	//음악코드, 곡제목, 아티스트, 장르, 발매일, 키워드
	public static JTextArea area7;	
	//레이블
	JLabel label1; JLabel label2; JLabel label3; 
	JLabel label4; JLabel label5; JLabel label6;
	

	
	void Employee() {
		employeemenu = new JFrame("직원메뉴");
		JPanel pan = new JPanel();
		pan.setLayout(null);		
		
		//버튼들 추가
		bt1 = new JButton("전체음악검색"); bt1.setBounds(380, 20, 120,30); bt1.addActionListener(this);
		bt2 = new JButton("음악추가"); bt2.setBounds(380, 66, 120,30); bt2.addActionListener(this);
		bt3 = new JButton("음악수정"); bt3.setBounds(380, 111, 120,30); bt3.addActionListener(this);
		bt4 = new JButton("음악삭제"); bt4.setBounds(380, 156, 120,30); bt4.addActionListener(this);
		bt5 = new JButton("종료"); bt5.setBounds(380, 246, 120,30); bt5.addActionListener(this);		
		bt6 = new JButton("초기화"); bt6.setBounds(380, 201,120,30); bt6.addActionListener(this);
		pan.add(bt1); pan.add(bt2); pan.add(bt3); pan.add(bt4); pan.add(bt5); pan.add(bt6);
		
		//텍스트필드들 추가
		area1 = new JTextField("코드"); area1.setBounds(20, 20, 330, 30); 
		area2 = new JTextField(""); area2.setBounds(20, 66, 330, 30); 
		area3 = new JTextField(""); area3.setBounds(20, 111, 330, 30); 
		area4 = new JTextField(""); area4.setBounds(20, 156, 330, 30); 
		area5 = new JTextField(""); area5.setBounds(20, 201, 330, 30); 
		area6 = new JTextField(""); area6.setBounds(20, 246, 330, 30); 
		
		//레이블 추가
		label1 = new JLabel("Code"); label1.setBounds(20, 5, 30, 15);
		label2 = new JLabel("Tilte"); label2.setBounds(20, 52, 50, 15);
		label3 = new JLabel("Artist"); label3.setBounds(20, 97, 50, 15);
		label4 = new JLabel("Gerne"); label4.setBounds(20, 142, 50, 15);
		label5 = new JLabel("Release"); label5.setBounds(20, 187, 50, 15);
		label6 = new JLabel("Keyword"); label6.setBounds(20, 232, 50, 15);
		
		
		pan.add(label1); pan.add(area1); 
		pan.add(label2); pan.add(area2); 
		pan.add(label3); pan.add(area3); 
		pan.add(label4); pan.add(area4); 
		pan.add(label5); pan.add(area5); 
		pan.add(label6); pan.add(area6); 
		
		
		//스크롤추가!		
		area7 = new JTextArea("");  
		JScrollPane scroll = new JScrollPane(area7);
		scroll.setBounds(20, 290, 480, 170);
		pan.add(scroll);	
		
		//직원메뉴 실행 시 전체음악보기 자동 실행
		boolean r2 = controller.SubControllerEX("MUSIC", 1,null);
		if(r2) {
			System.out.println("전체음악보기 성공!");
		}
		
		employeemenu.setBounds(100,100,535,510);
		employeemenu.add(pan);
		employeemenu.setVisible(true);
		
	}
	
	//회원메뉴
	JFrame membermenu;
	JButton button1;
	JTextArea meberArea;
	JScrollPane memberScroll;
	
	void Member() {
		membermenu = new JFrame("회원메뉴");				
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		button1 = new JButton("전체음악검색"); button1.setBounds(380, 20, 120,30);
				
		pan.add(button1);
		
		meberArea = new JTextArea(""); 
		JScrollPane scroll = new JScrollPane(meberArea);
		scroll.setBounds(17, 270, 480, 170);
		pan.add(scroll);
		
		
		membermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		membermenu.setBounds(100,100,530,500);
		membermenu.add(pan);	
		membermenu.setVisible(true);
	}
	
		

	
	//버튼클릭시 액션
	@Override
	public void actionPerformed(ActionEvent e) {
            
            //회원가입버튼
		    if(e.getSource()==signup) {
		    	System.out.println("Sign Up");
		    	SignUp();
		    }
		
		    if(e.getSource()==btnSignInput) {
		    	    AuthDTO dto = new AuthDTO(txtSignId.getText(),txtSignPw.getText());
		    		boolean r = controller.SubControllerEX("AUTH", 3, dto);
		    		if(r) {
		    			JOptionPane.showMessageDialog(null, "회원가입 성공");
		    			signupmenu.setVisible(false);
		    		}else{
		    			JOptionPane.showMessageDialog(null, "회원가입 실패");
		    			signupmenu.setVisible(false);
		    		}
		    	}
		
		    //로그인버튼
		    //직원로그인
			if(e.getSource() == btnLogin ) {
			System.out.println("LOGIN");
			
			if(rbtnEmp.isSelected())
			{
				AuthDTO dto = new AuthDTO(txtLoginId.getText(),txtLoginPw.getText());
				boolean r = controller.SubControllerEX("AUTH", 2, dto);
				if(r)
				{	
					Employee();
					
					loginMenu.setVisible(false); //로그인인증이성공했으면 창을 보여줄 필요가없다.
					System.out.println("실행?");


				}else
				{
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				
			//회원로그인
			}else if(rbtnMem.isSelected())
			{
				AuthDTO dto = new AuthDTO(txtLoginId.getText(),txtLoginPw.getText());
				boolean r = controller.SubControllerEX("AUTH", 1, dto);
				if(r)
				{	
					loginMenu.setVisible(false);
					Member();
				}else
				{
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}				
				
			}			 
		 }
		 if(e.getSource() == btnExit) {
			 System.out.println("종료 버튼 누름!");
			 System.exit(-1);
		 }
		 
		 //직원메뉴 내부 버튼
		 if(e.getSource() ==bt1) {
			area7.setText("");
			System.out.println("전체보기 누름!");
			MusicDTO dto = null;
			boolean r2 = controller.SubControllerEX("MUSIC", 1,dto);
			if(r2) {
				System.out.println("전체음악보기성공!");
			}
		 }
		 if(e.getSource()==bt2) {
			MusicDTO dto = new MusicDTO(area1.getText(),area2.getText(),area3.getText()
					,area4.getText(),area5.getText(),area6.getText());
			boolean r2 = controller.SubControllerEX("MUSIC", 2, dto);
			area7.setText("");
			boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
			if(r1&&r2) {
				System.out.println("INSERT성공!");
			}
		 }
		 if(e.getSource()==bt3) {
			 MusicDTO dto = new MusicDTO(area1.getText(),area2.getText(),area3.getText()
						,area4.getText(),area5.getText(),area6.getText());
				boolean r2 = controller.SubControllerEX("MUSIC", 3, dto);
				area7.setText("");
				boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
				if(r1&&r2) {
					System.out.println("INSERT성공!");
				}
				
		 }
		 if(e.getSource()==bt4) {
			 System.out.println("삭제버튼 누름!");
			 MusicDTO dto = new MusicDTO(area1.getText());
			boolean r2 = controller.SubControllerEX("MUSIC", 4, dto);
			area7.setText("");
			boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
			if(r1&&r2) {
				System.out.println("INSERT성공!");
			}
		 }
		 if(e.getSource()==bt5) {
			 System.exit(-1);
		 }
		 if(e.getSource()==bt6) {
			 area1.setText("");
			 area2.setText("");
			 area3.setText("");
			 area4.setText("");
			 area5.setText("");
			 area6.setText("");
		 }
		 
		 
	}

	//키보드 이벤트
	@Override
	public void keyTyped(KeyEvent e) {
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_TAB&&e.getSource()==txtLoginId) {
			txtLoginPw.requestFocus();
			txtLoginPw.setText("");
			System.out.println("탭키입력");
		}
		
		if(e.getKeyCode()==10&&e.getSource()==txtLoginPw) {
			System.out.println("엔터키입력");
		}
	}

	
	
	


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		if(e.getSource()==txtLoginId) {
			txtLoginId.setText("");
		}
		if(e.getSource()==txtLoginPw) {
			txtLoginPw.setText("");
		}
		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}