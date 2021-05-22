package tojeju;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class Login extends JFrame implements ActionListener, MouseListener {

	
	static String myId;
	
	public static String getMyId() {
		return myId;
	}

	public static void setMyId(String myId) {
		Login.myId = myId;
	}

	MemberDTO memberDTO;
	Container container = getContentPane();
	Container containerJoinM = getContentPane();

	JPanel panelM = new JPanel();
	JPanel panelB = new JPanel();
	JPanel cover = new JPanel();

	JPanel panelBackground;
	JPanel containerlog = new JPanel();
	JPanel containerlogInner = new JPanel();

	JPanel JMT;
	JPanel JMC = new JPanel();
	JPanel JMB = new JPanel();

	JPanel Left = new JPanel();
	JPanel Center = new JPanel();
	JPanel Right = new JPanel();
	JPanel CenterTop = new JPanel();
	JPanel CenterC = new JPanel();
	JPanel CenterBottom = new JPanel();

//	JLabel label = new JLabel("아이디/비밀번호 찾기");
	JLabel label;
	JLabel labelId;
	JLabel labelPw;
	JLabel labelBu1;
	JLabel labelBu2;

	JTextField id = new JTextField(15);
	JPasswordField pw = new JPasswordField(15);

	JButton buttonlogin = new JButton(" 로그인 ");
	JButton buttonjoinM = new JButton("회원가입");

	boolean result = false;

	
	public Login() {

		setTitle("제주 여행 가이드");
		setSize(1080, 658);
		setLocation(350, 200);

		initMain();
		initLog();

		start();

		
		setVisible(true);
		setResizable(false);
		
		
		

	}


	
	private void initLog() {
		
		ImageIcon iconMian = new ImageIcon("img/first.png");
	
		panelBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(iconMian.getImage(), 0, 0, null);
			}
		};

		container.setLayout(null);
		container.add(panelBackground);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1080, 700);
		panelBackground.add(cover);

		//여기
		cover.setLayout(null);
		ImageIcon iconButton1 = new ImageIcon("img/main2.png");
		ImageIcon iconButton2 = new ImageIcon("img/main2.png");
		ImageIcon iconId = new ImageIcon("img/main2.png");
		ImageIcon iconPw = new ImageIcon("img/main2.png");
		ImageIcon iconSearchIdNPw = new ImageIcon("img/main1.png");
		label = new JLabel(iconSearchIdNPw);
		labelId = new JLabel(iconId);
		labelPw = new JLabel(iconPw);
		labelBu1 = new JLabel(iconButton1);
		labelBu2 = new JLabel(iconButton2);
		panelBackground.add(label);

		panelBackground.add(buttonlogin);
		panelBackground.add(buttonjoinM);
		panelBackground.add(id);
		panelBackground.add(pw);
		
		
		label.setBounds(284, 300, iconSearchIdNPw.getIconWidth(), iconSearchIdNPw.getIconWidth());
		id.setBounds(108, 258, 295, 35);
		id.setText(" 아이디");
		id.setFont(new Font("맑은 고딕",Font.BOLD,15));
		id.setForeground(Color.LIGHT_GRAY);
		pw.setBounds(108, 300, 295, 35);
		pw.setText(" 비밀번호입력하세요");
		pw.setFont(new Font("맑은 고딕",Font.BOLD,15));
		pw.setForeground(Color.LIGHT_GRAY);
		
		
		
		buttonjoinM.setBounds(60,444, iconButton1.getIconWidth(), iconButton1.getIconHeight());
		buttonjoinM.setBorderPainted(false);
		buttonjoinM.setContentAreaFilled(false);
		
		buttonjoinM.setText("");
		buttonlogin.setBounds(265,444, iconButton1.getIconWidth(), iconButton1.getIconHeight());
		buttonlogin.setBorderPainted(false);
		buttonlogin.setContentAreaFilled(false);
		buttonlogin.setText("");
		

	}

	// 메인 화면구성
	private void initMain() {

	}

	// 이벤트
	private void start() {
		id.addMouseListener(this);
		pw.addMouseListener(this);
		pw.addActionListener(this);
		buttonjoinM.addActionListener(this);
		buttonjoinM.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		buttonlogin.addActionListener(this);
		buttonlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		label.addMouseListener(this);
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//마우스 손가락 표시
//		label.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseExited(MouseEvent e) {
//				Cursor cursor = new Cursor().getDefaultCursor();
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				 Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
//				 setCursor(cursor);
//			}
//		});
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pw) {
			pw.setText("*");

		} else if (e.getSource() == buttonjoinM) {
			new JoinM().initFirst();
		} else if (e.getSource() == buttonlogin) {
			// 아이디 미입력
			if (id.equals("") || id == null) {
				String title = "아이디 입력오류";
				String result = "아이디를 입력해주세요";
				Dialog dialog = new Dialog(title, result);

				// 암호 미입력
			} else if (pw.equals("") || pw == null) {
				String title = "비밀번호 오류";
				String result = "비밀번호를 입력하지 않았습니다.";
				Dialog dialog = new Dialog(title, result);
				// 아이디 비밀번호 매칭 시작
			} else {
				String checkid = id.getText();
				String checkpw = new String(pw.getPassword());

				// 아이디 매칭 시작
				MemberDAO serverOn = new MemberDAO();
				MemberDTO memberDTO = new MemberDTO();
				memberDTO = serverOn.tryLogin(checkid, checkpw);
			
				
				//아이디 비밀번호 매칭 시도 
				if (memberDTO == null) {
					String title = "로그인 오류 오류";
					String result = "아이디/비밀번호를 확인 후 시도해주세요.";
					Dialog dialog = new Dialog(title, result);
				//정보가 동일할 시
				} else {
					Mainpage mainpage = new Mainpage();
					Login.setMyId(memberDTO.getId());
					System.out.println(Login.getMyId()+"로그인 하셨습니다.");
					this.setVisible(false);
			
					
				}



			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent k) {
		if (k.getClickCount() == 2) {
		if (k.getSource() == id) {
			id.setText("");
			id.setForeground(Color.black);

		} else if (k.getSource() == pw) {
			pw.setText("");
			pw.setForeground(Color.black);
		}
		
		}
		if (k.getSource() == label) {
			SearchIdAndPassword1 on = new SearchIdAndPassword1();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

