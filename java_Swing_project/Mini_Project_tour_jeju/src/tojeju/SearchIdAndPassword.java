package tojeju;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


class SearchIdAndPassword1 extends JFrame implements ActionListener {

	MemberDTO memberDTO;
	Container container = getContentPane();

	JButton button1 = new JButton("찾기");
	JButton button2 = new JButton("닫기");
	JLabel label = new JLabel("아이디 찾기", JLabel.CENTER);

	JPanel panelN = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelS = new JPanel();
	JPanel panelCC = new JPanel();
	JPanel panelCL = new JPanel();

	JPanel cover = new JPanel();

	JRadioButton JrId = new JRadioButton("ID 찾기", true);
	JRadioButton JrPw = new JRadioButton("비밀번호 찾기");

	JLabel labelName = new JLabel("이        름 : ", JLabel.LEFT);
	
	JLabel labelBirth = new JLabel("생년월일 : ", JLabel.LEFT);
	JLabel labelId = new JLabel("아  이  디 : ", JLabel.LEFT);

	JLabel labelIdFound;
	JLabel labelIdFoundValue;

	JTextField textFieldName = new JTextField(20);
	JTextField textFieldBirth = new JTextField(20);
	JTextField textFieldId = new JTextField(20);

	ButtonGroup buttonGroup = new ButtonGroup();

	public SearchIdAndPassword1() {

		setTitle("아이디 찾기");
		setSize(350, 300);
		setLocation(400, 400);

		init();
		start();

		setVisible(true);
	}

	private void init() {

		container.setLayout(new BorderLayout());
		container.add("North", panelN);
		container.add("East", panelE);
		container.add("West", panelW);
		container.add("Center", panelC);
		container.add("South", panelS);

		panelN.setLayout(new FlowLayout());
		panelN.add(JrId);
		panelN.add(JrPw);

		buttonGroup.add(JrId);
		buttonGroup.add(JrPw);

		panelC.setBackground(Color.white);
		panelC.setLayout(new BorderLayout());
		panelC.add("West", panelCL);
		panelCL.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelC.add("Center", panelCC);
		panelCC.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		panelCL.setLayout(new GridLayout(4, 1, 5, 5));
		panelCL.add(labelId);
		panelCL.add(labelName);
		panelCL.add(labelBirth);

		panelCC.setLayout(new GridLayout(4, 1, 5, 5));
		panelCC.add(textFieldId);
		textFieldId.setEditable(false);
		textFieldId.setFont(new Font("맑은 고딕",Font.BOLD,14));
		
		panelCC.add(textFieldName);
		textFieldName.setFont(new Font("맑은 고딕",Font.BOLD,14));
		panelCC.add(textFieldBirth);
		textFieldBirth.setText(" YYYY-MM-DD");
		textFieldBirth.setFont(new Font("맑은 고딕",Font.BOLD,14));
		textFieldBirth.setForeground(Color.LIGHT_GRAY);

		panelS.setLayout(new FlowLayout());
		panelS.add(button1);
		panelS.add(button2);

	}

	private void start() {
		button2.addActionListener(this);
		button1.addActionListener(this);
		JrId.addActionListener(this);
		JrPw.addActionListener(this);

		textFieldBirth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				textFieldBirth.setText("");
				textFieldBirth.setForeground(Color.black);
				
			}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (JrId.isSelected()) {
			textFieldId.setEditable(false);
			textFieldId.setText("");
		}
			
		if (JrPw.isSelected())
			textFieldId.setEditable(true);
		// 취소버튼
		if (e.getSource() == button2) {
			dispose();

			// 확인버튼
		} else if (e.getSource() == button1) {
			String getResult = null;// 아이디 결과값
			// 케이스 1 아이디 찾기
			if (JrId.isSelected()) {
				MemberDTO memberDTO = null;
				// 이름 미입력시
				if (textFieldName.getText().equals("") || textFieldName.getText().equals(null)) {
					String title = "이름 미입력";
					String result = "성함을 입력해주세요.";
					Dialog dialog = new Dialog(title, result);
					// 생년월일 미입력시
				}
				if (textFieldBirth.getText().equals("") || textFieldBirth.getText().equals(null)) {
					String title = "생년월일 미입력";
					String result = "생년월일을 입력하세요.";
					Dialog dialog = new Dialog(title, result);
				} else {
					MemberDAO serverOn = new MemberDAO();
					memberDTO = serverOn.searchNameAndBirth(textFieldName.getText(), textFieldBirth.getText());

					if (memberDTO != null)
						getResult = memberDTO.getId();
					else
						getResult = null;
					
					if (getResult == null) {
						String title = "아이디 찾기";
						String result = "찾으시는 아이디가 없습니다.";
						Dialog dialog = new Dialog(title, result);

					} else {
						String title = "아이디 찾기";
						String result = "찾으시는 아이디는 : '" + getResult + "' 입니다.";
						Dialog dialog = new Dialog(title, result);

					}

				}
				

				// 케이스 2 비밀번호 찾기
			} else if (JrPw.isSelected()) {
				MemberDTO memberDTO = null;

				// 아이디 미입력시
				if (textFieldId.getText().equals("") || textFieldId.getText().equals(null)) {
					String title = "아이디 미입력";
					String result = "아이디를 입력하세요.";
					Dialog dialog = new Dialog(title, result);
					// 이름 미입력시
				} else if (textFieldName.getText().equals("") || textFieldName.getText().equals(null)) {
					String title = "이름 미입력";
					String result = "성함을 입력해주세요.";
					Dialog dialog = new Dialog(title, result);
					// 생년월일 미입력시
				} else if (textFieldBirth.getText().equals("") || textFieldBirth.getText().equals(null)) {
					String title = "생년월일 미입력";
					String result = "생년월일을 입력하세요.";
					Dialog dialog = new Dialog(title, result);
				} else {
					MemberDAO serverOn = new MemberDAO();
					memberDTO = serverOn.searchIdAndNameAndBirth(textFieldId.getText(), textFieldName.getText(),
							textFieldBirth.getText());

					if (memberDTO != null)
						getResult = memberDTO.getPw();
					else
						getResult = null;

				}
				if (getResult == null) {
					String title = "비밀번호 찾기";
					String result = "등록된 아이디가 아닙니다.";
					Dialog dialog = new Dialog(title, result);

				} else {
					String title = "비민번호 찾기";
					String result = "찾으시는 아이디의 비밀번호는 : '" + getResult + "' 입니다.";
					Dialog dialog = new Dialog(title, result);

				}

			}

		}

	}
}

public class SearchIdAndPassword {
	public static void main(String[] args) {
		new SearchIdAndPassword1();
	}
}
