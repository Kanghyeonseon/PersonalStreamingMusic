package KHS.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import KHS.controller.FrontController;
import KHS.dto.ListDTO;
import javazoom.jl.player.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


class PlayMusic extends Thread {
	private Player player; //jlayer 라이브러리 중 하나
	private boolean isLoop; //현재 곡이 무한반복인가요?
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public PlayMusic(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
//			file = new File(".\\src\\music\\"+name+".mp3"); 
			file = new File(KHS.main.Main.class.getResource("../../music/" + name).toURI()); 

			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); //버퍼에 파일을 담아서 불러온다.
			player = new Player(bis); //플레이어는 해당 파일을 담아올 수 있도록 해준다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getTime() {
				//현재재생중인 음악이 어떤 위치에 실행되고 있는지를 알려주는 메소드
		if(player == null) {
			return 0;
		}	return player.getPosition();
	}
	
	public void close() {
				//음악이 언제 실행되고 있던간에 종료할 수 있게 해주는 메소드
		isLoop = false;
		player.close();
		this.interrupt(); //곡을실행하는 스레드를 종료한다.
	}
	@Override
	public void run() { //쓰레드를 상속받으면 무조건 사용해야하는 함수
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



public class builderMemberList {

	private JFrame frame;
	private String id;
	private String list_name;
	private JTextField textField;
	private JButton btnPlay;
	public static JTextArea txtList = new JTextArea();
	
	FrontController controller = new FrontController();
	private JButton btnStop;
	
	

	public builderMemberList(String Member_Id, String List_Name) {
		
		id = Member_Id;
		list_name = List_Name;
		initialize();
	}
	
	 
	

	private void initialize() {
		ListDTO dto = new ListDTO(id);
		boolean r = controller.SubControllerEX("LIST", 4, dto);
		if(r) {
			System.out.println("목록불러오기 성공");
		}
		
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
				PlayMusic music = new PlayMusic(textField.getText() + ".mp3", false);
				music.start();
			}
		});
		
		btnPlay.setBounds(313, 316, 91, 23);
		panel.add(btnPlay);
		
		btnStop = new JButton("정지");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("정지버튼누름!");
				PlayMusic music = new PlayMusic(textField.getText() + ".mp3", false);
				music.close();
			}
		});
		btnStop.setBounds(446, 316, 91, 23);
		panel.add(btnStop);
		frame.setVisible(true);
	}
}


