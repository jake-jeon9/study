package tojeju;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class JoinM extends JFrame implements ActionListener {

	MemberDTO memberDTO;
	
	Container container = getContentPane();
	JButton button1 = new JButton("가입하기");
	JButton button2 = new JButton("취소하기");
	Icon icon = new ImageIcon("img/LOGO.png");
	
	JButton button3 = new JButton("중복확인");

	JLabel newLogo = new JLabel(icon,JLabel.CENTER);
	
	JTextField id = new JTextField(20);
	JTextField name = new JTextField(20);
	JTextField birth = new JTextField(20);
	JTextField age = new JTextField(20);
	JPasswordField pw1 = new JPasswordField(20);
	JPasswordField pw2 = new JPasswordField(20);

	JPanel panelTop = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelBotton = new JPanel();
	
	//J라벨 생성
	JLabel label1 = new JLabel("아이디", JLabel.LEFT);
	JLabel label2 = new JLabel("비밀번호", JLabel.LEFT);
	JLabel label3 = new JLabel("비밀번호 재확인", JLabel.LEFT);
	JLabel label4 = new JLabel("이름", JLabel.LEFT);
	JLabel label5 = new JLabel("나이", JLabel.LEFT);
	JLabel label6 = new JLabel("생년월일", JLabel.LEFT);
	
	//로그인패널생성
	JPanel p1= new JPanel();
	JPanel p2= new JPanel();
	JPanel p3= new JPanel();
	JPanel p4= new JPanel();
	JPanel p5= new JPanel();
	JPanel p6= new JPanel();
	
	boolean checkMyid = false;

	public JoinM() {

		setTitle("회원가입");
		setSize(450, 670);
		setLocation(300, 300);
		
		initFirst();
		start();

		setVisible(true);
		setResizable(false);
	}

	public void initFirst() {
				
		container.setLayout(new BorderLayout());
		
		container.add("North", panelTop);
		container.add("Center", panelCenter);
		container.add("South", panelBotton);

		panelTop.add(newLogo);

		panelCenter.setLayout(new GridLayout(6,1,10,10));
		panelCenter.setBorder(new EmptyBorder(15, 55, 10, 55));
		
		panelCenter.add(p1);
		p1.setLayout(new BorderLayout());
		p1.add("North", label1);
		p1.add("Center", id);
		id.setText(" 아이디를 입력하세요.");
		id.setForeground(Color.lightGray);
		id.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panelCenter.add(p2);
		p2.setLayout(new BorderLayout());
		p2.add("North", label2);
		p2.add("Center", pw1);
		pw1.setText(" 비밀번호를 입력하세요.");
		pw1.setForeground(Color.lightGray);
		pw1.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panelCenter.add(p3);
		p3.setLayout(new BorderLayout());
		p3.add("North", label3);
		p3.add("Center", pw2);
		pw2.setText(" 한번더 입력해주세요.");
		pw2.setForeground(Color.lightGray);
		pw2.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panelCenter.add(p4);
		p4.setLayout(new BorderLayout());
		p4.add("North", label4);
		p4.add("Center", name);
		name.setText(" 이름을 입력하세요.");
		name.setForeground(Color.lightGray);
		name.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panelCenter.add(p5);
		p5.setLayout(new BorderLayout());
		p5.add("North", label5);
		p5.add("Center", age);
		age.setText(" 나이를 입력하세요.");
		age.setForeground(Color.lightGray);
		age.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panelCenter.add(p6);
		p6.setLayout(new BorderLayout());
		p6.add("North", label6);
		p6.add("Center", birth);
		birth.setText(" 2000-01-01");
		birth.setForeground(Color.lightGray);
		birth.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		panelBotton.setLayout(new FlowLayout());
		panelBotton.setBorder(new EmptyBorder(40,30,20,30));
		panelBotton.add(button1);
		panelBotton.add(button2);
		panelBotton.add(button3);
		
		//모든패널 색 하얀색
//		p1.setBackground(Color.white);
//		p2.setBackground(Color.white);
//		p3.setBackground(Color.white);
//		p4.setBackground(Color.white);
//		p5.setBackground(Color.white);
//		p6.setBackground(Color.white);
//		panelTop.setBackground(Color.white);
//		panelCenter.setBackground(Color.white);
//		panelBotton.setBackground(Color.white);
		

	}

	private void start() {
		
		button1.addActionListener(this);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);
		button3.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 버튼 클릭시 디폴트 문장 삭제.
		id.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
					if (k.getSource() == id)
					id.setText("");
					id.setForeground(Color.black);
				}

			}
		});
		pw1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				if (k.getSource() == pw1)
					
					pw1.setText("");
				pw1.setForeground(Color.black);
			}

			}
		});
		pw2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				if (k.getSource() == pw2)
					pw2.setText("");
				pw2.setForeground(Color.black);
				}

			}
		});
		name.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				if (k.getSource() == name)
					name.setText("");
				name.setForeground(Color.black);
				}
			}
		});
		birth.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				if (k.getSource() == birth)
					birth.setText("");
				birth.setForeground(Color.black);
				}
			}

		});
		age.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				if (k.getSource() == age)
					age.setText("");
				age.setForeground(Color.black);
				}
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String resultpw1;
		String resultpw2;
		
		//아이디 중복확인
		if(e.getSource()==button3) {
			String findid = id.getText();
			if(findid.equals("")||findid.equals(null)) {
				String title = "아이디 입력오류";
				String result = "아이디를 입력해주세요";
				Dialog dialog = new Dialog(title, result);
			}else {
				String returnResult;
				MemberDAO serverOn = new MemberDAO();
				
				MemberDTO memberDTO = serverOn.searchId(findid);
				
				if(memberDTO != null)returnResult = memberDTO.getId();
				else returnResult=null;
				
//				System.out.println("찾는 아이디 : " +returnResult);
				
				if(returnResult==null||returnResult.equals("")){
					String title = "ID중복검사";
					String result = "사용 가능한 ID 입니다.";
					Dialog dialog = new Dialog(title, result);
					checkMyid =true;
//					System.out.println("중복검사 불가능 진입");
				}else if(!returnResult.equals(null)||!returnResult.equals("")) {
					String title = "ID중복검사";
					String result = "이미 사용중인 아이디 입니다.";
					Dialog dialog = new Dialog(title, result);
//					System.out.println("중복검사 가능 진입");
					
				}
				
			}
		}	
			
		

		// 오류 검사 수 등록절차 실행. 각종 항목 입력 안함.
		if (e.getSource() == button1) {
			
			if(checkMyid) {
			// 입력된 정보들 읽어오기
			resultpw1 = new String(pw1.getPassword());
			resultpw2 = new String(pw2.getPassword());

		 //아이디 미입력
			 if (id.equals("") || id.equals(null)) {
				 String title = "아이디 입력오류";
				 String result = "아이디를 입력해주세요";
				 Dialog dialog = new Dialog(title, result);
			
		// 패드워드 1미입력
			} else if (pw1.equals("") || pw1.equals(null)) {
				String title = "비밀번호 오류";
				String result = "비밀번호를 입력하지 않았습니다.";
				Dialog dialog = new Dialog(title, result);
			
		// 패스워드 2 미입력
			}else if (pw2.equals("") || pw2.equals(null)) {
				String title = "비밀번호 오류";
				String result = "비밀번호를 입력하지 않았습니다.";
				Dialog dialog = new Dialog(title, result);
		// 이름 미입력
			}else if (name.equals("") || name.equals(null)) {
				String title = "이름 입력 오류";
				String result = "이름을 입력해주세요.";
				Dialog dialog = new Dialog(title, result);

		 // 나이 미입력
			}else if (age.equals("") || age.equals(null)) {
				String title = "생년월일 오류";
				String result = "생년월일을 입력해주세요.";
				Dialog dialog = new Dialog(title, result);
			
		// 생년월일 미입력
			}else if (age.equals("") || age.equals(null)) {
				String title = "나이입력 오류";
				String result = "나이를 입력해주세요.";
				Dialog dialog = new Dialog(title, result);
			 	
		// 패스워드 불일치.
			}else if (!resultpw1.equals(resultpw2)) {
					String title = "비밀번호 오류";
					String result = "비밀번호가 일치하지 않습니다.";
					Dialog dialog = new Dialog(title, result);

					pw1.setText("");
					pw2.setText("");
					
		//위에 모든 검사가 통과되면
		// 서버 등록
			}else {
				int resultReturn;
				String inId = id.getText();
				String inPw = new String(pw2.getPassword());
				String inName = name.getText();
				String inBirth = birth.getText();
				int inAge = Integer.parseInt(age.getText());
				
				MemberDAO serverOn = new MemberDAO();

				resultReturn = serverOn.insertDirect(inId,inPw,inName,inBirth,inAge);
				if(resultReturn>0) {
					String title = "회원가입 성공";
					String result = "가입 성공! 로그인 후 사용해주세요.";
					Dialog dialog = new Dialog(title, result);
//					System.out.println("가입여부" +resultReturn );
					System.out.println("가입자 명 : " + inId);
					super.dispose();
				}else {
					String title = "회원가입 실패";
					String result ="잠시 후 다시 시도해주세요.";
					Dialog dialog = new Dialog(title, result);
//					System.out.println("가입여부" +resultReturn );
				}
				
			}
			}else {
				String title = "회원가입 에러";
				String result ="ID 중복확인부터 해주세요.";
				Dialog dialog = new Dialog(title, result);
			}
			
		//버튼 2 취소버튼 ( 비활성화 처리 ) 
		} else if (e.getSource() == button2) {
			super.dispose();
			
		}

	}

}
