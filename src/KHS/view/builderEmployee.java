package KHS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import KHS.controller.FrontController;
import KHS.dto.MusicDTO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;

public class builderEmployee{

	private JFrame frame;
	
	//미리 추가해야하는 객체들...
	FrontController controller = new FrontController();
	public static JTextArea textArea = new JTextArea();
	private JTextField txtCode;
	private JTextField txtTitle;
	private JTextField txtArtist;
	private JTextField txtKeyword;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnDelete_1;
	private JLabel lblCode;
	private JLabel lblTitle;
	private JLabel lblArtist;
	private JLabel lblGenre;
	private JLabel lblRelease;
	private JLabel lblKeyword;
	private JComboBox comboBox;
	private JList list;
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl calendar; String cal;


	public builderEmployee() {
		initialize();
	}		

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 772, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"하하", "하하"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(35, 424, 713, 144);
		panel.add(list);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"댄스", "발라드","알앤비","팝송","힙합","인디음악","록/메탈","트로트"}));
		comboBox.setBounds(205, 120, 116, 21);
		panel.add(comboBox);
		
		txtCode = new JTextField();
		txtCode.setBounds(205, 27, 116, 21);
		panel.add(txtCode);
		txtCode.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(205, 58, 116, 21);
		panel.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtArtist = new JTextField();
		txtArtist.setBounds(205, 89, 116, 21);
		panel.add(txtArtist);
		txtArtist.setColumns(10);
		
		txtKeyword = new JTextField();
		txtKeyword.setBounds(205, 186, 116, 21);
		panel.add(txtKeyword);
		txtKeyword.setColumns(10);
		
		calendar = new JDatePickerImpl(datePanel);
		calendar.setBounds(205, 151, 116, 30);
		panel.add(calendar);
		
		boolean r = controller.SubControllerEX("MUSIC", 1, null);
		if(r) { System.out.println("기본 전체조회!"); }
		
		JButton btnSelect = new JButton("전체조회");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("전체조회 버튼 누름!");
				boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
				if(r1) {System.out.println("전체조회 성공 ^^");}
				else {System.out.println("전체조회 실패 ㅋ");}
			} 
		});
		btnSelect.setBounds(588, 27, 97, 23);
		panel.add(btnSelect);		
		
		JButton btnInsert = new JButton("삽입");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				MusicDTO dto = new MusicDTO(txtCode.getText(),txtTitle.getText(),txtArtist.getText()
							,(String)comboBox.getSelectedItem(),model.getYear()+"-"+(model.getMonth()+1)+"-"+model.getDay(),txtKeyword.getText());
				boolean r2 = controller.SubControllerEX("MUSIC", 2, dto);
				boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
				if(r1&&r2) {System.out.println("삽입 성공!");} else {System.out.println("삽입 실패!"); }
			}
		});
		btnInsert.setBounds(588, 60, 97, 23);
		panel.add(btnInsert);
		
		btnUpdate = new JButton("업데이트");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicDTO dto = new MusicDTO(txtCode.getText(),txtTitle.getText(),txtArtist.getText()
							,(String)comboBox.getSelectedItem(),model.getYear()+"-"+(model.getMonth()+1)+"-"+model.getDay(),txtKeyword.getText());
				boolean r2 = controller.SubControllerEX("MUSIC", 3, dto);
				boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
				if(r1&&r2) {System.out.println("업데이트 성공!");} else {System.out.println("업데이트 실패!"); }
			}
		});
		btnUpdate.setBounds(588, 97, 97, 23);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicDTO dto = new MusicDTO(txtCode.getText());
				boolean r2 = controller.SubControllerEX("MUSIC", 4, dto);
				boolean r1 = controller.SubControllerEX("MUSIC", 1, null);
				if(r1&&r2) {System.out.println("삭제 성공!");} else {System.out.println("삭제 실패!"); }
			}
		});
		btnDelete.setBounds(588, 132, 97, 23);
		panel.add(btnDelete);
		
		btnDelete_1 = new JButton("종료");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
				System.out.println("종료버튼 누름!");
			}
		});
		btnDelete_1.setBounds(588, 165, 97, 23);
		panel.add(btnDelete_1);
		
		lblCode = new JLabel("Code");
		lblCode.setBounds(92, 30, 57, 15);
		panel.add(lblCode);
		
		lblTitle = new JLabel("Title");
		lblTitle.setBounds(92, 61, 57, 15);
		panel.add(lblTitle);
		
		lblArtist = new JLabel("Artist");
		lblArtist.setBounds(92, 92, 57, 15);
		panel.add(lblArtist);
		
		lblGenre = new JLabel("Genre");
		lblGenre.setBounds(92, 123, 57, 15);
		panel.add(lblGenre);
		
		lblRelease = new JLabel("Release");
		lblRelease.setBounds(92, 154, 57, 15);
		panel.add(lblRelease);
		
		lblKeyword = new JLabel("Keyword");
		lblKeyword.setBounds(92, 189, 57, 15);
		panel.add(lblKeyword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 301, 723, 98);
		panel.add(scrollPane);
		scrollPane.setViewportView(textArea);
		frame.setLocationRelativeTo(null); //가운데정렬
		frame.setVisible(true);
	}
}
