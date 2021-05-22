package tojeju;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


class Mainpage extends JFrame implements ActionListener, MouseListener {

	DialogPhoto dialogPhoto;
	
	
	Container container = getContentPane();

	ImageIcon img1 = new ImageIcon("img/title.png");
	ImageIcon img2 = new ImageIcon("img/homebackground.png");
	ImageIcon img3 = new ImageIcon("img/homebutton1.png");
	ImageIcon img4 = new ImageIcon("img/homebutton2.png");
	ImageIcon img5 = new ImageIcon("img/homebutton3.png");
	ImageIcon img6 = new ImageIcon("img/mypagebackground.png");
	ImageIcon img7 = new ImageIcon("img/mypage1.png");//마이페이지 라벨
	ImageIcon img8 = new ImageIcon("img/mainpanel.png");
	ImageIcon img9 = new ImageIcon("img/rankingbackground.png");
	ImageIcon img10 = new ImageIcon("img/label.png");
	
	ImageIcon icon1 = new ImageIcon("img/icon1.png"); //새글쓰기
	ImageIcon icon2 = new ImageIcon("img/icon2.png"); //삭제하기
	ImageIcon icon3 = new ImageIcon("img/icon3.png"); //갱신하기

	JLabel label1 = new JLabel(img10);
	JLabel label2 = new JLabel(img2);
	JLabel labelButton1 = new JLabel(img3);
	JLabel labelButton2 = new JLabel(img4);
	JLabel labelButton3 = new JLabel(img5);
	JLabel label_my = new JLabel(img7, JLabel.LEFT);
	
	String notice;

	JButton buttonR1= new JButton();
	JButton buttonR2= new JButton();
	JButton buttonR3= new JButton();
	JButton buttonH1= new JButton();
	JButton buttonH2= new JButton();
	JButton buttonH3= new JButton();
	JButton buttonP1= new JButton();		
	JButton buttonP2= new JButton();
	JButton buttonP3= new JButton();
	
	

	JPanel panelN = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(img1.getImage(), 0, 0, null);
		}
	};	//상단패널

	JPanel panelC = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(img8.getImage(), 0, 0, null);
		}
	};	//센터 패널

	JPanel panel1 = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(img2.getImage(), 0, 0, null);
		}
	};
	
	JPanel panel2 = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(img9.getImage(), 0, 0, null);
		}
	}; 
	
	JPanel panel3 = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(img6.getImage(), 0, 0, null);
		}
	};
	

	JPanel panelButton1 = new JPanel();
	JPanel panelButton2 = new JPanel();
	JPanel panelButton3 = new JPanel();

	// 탭
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

		
		// 보충패널
		JPanel panel_top = new JPanel(); // 상단
		JPanel panel_center = new JPanel(); // 센터
		JPanel panel_bottom = new JPanel(); // 하단(버튼)
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

		// 버튼
		JButton button1 = new JButton(icon1); //새글쓰기
		JButton button2 = new JButton(icon2); 
		JButton button3 = new JButton(icon3); //갱신버튼 누르면 데이터베이스 목록을 불러온다.

		String[] columnName = { "  ", "날짜", "제목", "장소", "내용" };
		DefaultTableModel tableModel = new DefaultTableModel(columnName, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; // 테이블 수정여부 결정(불가)
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		
		/**
		 * 대화창 (다이어리작성)전역변수
		 * -------------------------------------------------------------------------
		 **/
		JDialog write = new JDialog(this, "내 다이어리 작성");
		Container dcontainer = write.getContentPane();

		// 버튼
		JButton dbutton1 = new JButton("사진 올리기"); // 사진버튼
		JButton dbutton2 = new JButton("저장"); // 저장버튼
		JButton dbutton3 = new JButton("취소"); // 취소버튼

		// 텍스트필드
		JTextField dtextField1 = new JTextField(" 00-00-00 "); // 날짜
		JTextField dtextField2 = new JTextField(" 장소을 입력해주세요."); // 제목
		JTextField dtextField3 = new JTextField(" 제목를 입력해주세요."); // 장소

		// 라벨
		JLabel dlabel1 = new JLabel("날짜 입력 : ", JLabel.LEFT);
		JLabel dlabel3 = new JLabel(" 날씨는 어땠나요? ", JLabel.LEFT);
		JLabel dlabel4 = new JLabel(" DIARY");
		JLabel dlabel5 = new JLabel(" 나의 평점은 어떤가요?");

		// 체크항목
		// 1.날씨
		JCheckBox dwhether1 = new JCheckBox("맑음");
		JCheckBox dwhether2 = new JCheckBox("비");
		JCheckBox dwhether3 = new JCheckBox("흐림");
		JCheckBox dwhether4 = new JCheckBox("눈");
		JCheckBox dwhether5 = new JCheckBox("바람");
		// 2.평점
		JRadioButton dfeel1 = new JRadioButton("매우만족");
		JRadioButton dfeel2 = new JRadioButton("만족");
		JRadioButton dfeel3 = new JRadioButton("보통");
		JRadioButton dfeel4 = new JRadioButton("별로");
		JRadioButton dfeel5 = new JRadioButton("최악");
		// 3.버튼그룹
		ButtonGroup dbuttonGroup1 = new ButtonGroup(); // 체크박스
		ButtonGroup dbuttonGroup2 = new ButtonGroup(); // 라디오박스

		// 텍스트에리어
		JTextArea dtextArea = new JTextArea(" 여행 다이어리 내용을 입력해주세요. ");
		JScrollPane dscrollPane = new JScrollPane(dtextArea);

		// 패널
		JPanel dpanel1 = new JPanel(); // 상단(날짜~장소)
		JPanel dpanel2 = new JPanel(); // 센터(사진올리기-텍스트에리어-평점)
		JPanel dpanel3 = new JPanel(); // 하단(버튼)
		// 보충패널
		JPanel dp1 = new JPanel();
		JPanel dp2 = new JPanel();
		JPanel dp3 = new JPanel();
		JPanel dp4 = new JPanel();
		JPanel dp5 = new JPanel();
		JPanel dp6 = new JPanel();
		JPanel dp7 = new JPanel();
		JPanel dp8 = new JPanel();
		JPanel dp9 = new JPanel();

		// 대화상자
		JDialog dialog_finish = new JDialog(write, "완료");
		Container dialogContainer = dialog_finish.getContentPane();
		JLabel dialogLabel_finish = new JLabel("저장이 완료되었습니다.", JLabel.CENTER);

		MypageDAO mypageDAO = new MypageDAO();

		// 리스트 리스너 관련

		String selectedData = null;
		
		
		JLabel lableNotice = new JLabel();
		
		
	public Mainpage() {
		setTitle("제주도 여행 가이드");
		setBounds(350, 200, 1080, 672);
		
		init();
		start();
		init_mypage();
		set_write(); // 다이어리쓰기창 화면 구성
		start_mypage();
		creatTable();
		event_write(); // 다이어리쓰기창 이벤트 설정
		event_newCreate();
		init_panel2();
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		
		container.setLayout(new BorderLayout());
		container.add("North", panelN);
		container.add("Center", panelC);
		container.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	
		// 상단 이미지
		panelN.setOpaque(false);
		panelN.add("Center", label1);

		// 패널구성 (탭)
		panelC.setLayout(new BorderLayout());
		panelC.add(tabbedPane);
		panelC.setCursor(new Cursor(Cursor.HAND_CURSOR));

		tabbedPane.addTab("", new ImageIcon("img/tab01.png"), panel1);
//		tabbedPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		panel1.setLayout(null);
		panel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		panel1.add(labelButton1);
		labelButton1.setBounds(680, 72, 300, 200);

		panel1.add(labelButton2);
		labelButton2.setBounds(670, 185, 300, 200);

		panel1.add(labelButton3);
		labelButton3.setBounds(670, 307, 300, 200);

		tabbedPane.addTab("", new ImageIcon("img/tab02.png"), panel2);
		
		panel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		tabbedPane.addTab("", new ImageIcon("img/tab03.png"), panel3);
		panel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}

	private void start() {
		
		labelButton1.addMouseListener(this);
		labelButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelButton2.addMouseListener(this);
		labelButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelButton3.addMouseListener(this);
		labelButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));

//		

	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == labelButton1) {
			new Event1();
//			new EnrollReview();
		} else if (e.getSource() == labelButton2) {
			new Event2();
		} else if (e.getSource() == labelButton3) {
			new Event3();
		}

	}

	public void creatTable() {

		panel_center.add("Center", scrollPane);
//		table.setCellSelectionEnabled(rootPaneCheckingEnabled);
//		table.setCellSelectionEnabled(true);
		scrollPane.getViewport().setBackground(Color.white);

		// 테이블 크기조절
		table.getColumn("  ").setPreferredWidth(30);
		table.getColumn("날짜").setPreferredWidth(80);
		table.getColumn("제목").setPreferredWidth(150);
		table.getColumn("장소").setPreferredWidth(150);
		table.getColumn("내용").setPreferredWidth(545);
		table.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		table.setRowHeight(20);
		table.getTableHeader().setReorderingAllowed(false); // 헤더이동 불가

		// 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = table.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		for (int a = 0; a < 4; a++) {
			tcm.getColumn(a).setCellRenderer(dtcr); // 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		}

		// 선택 시 정보 읽어오는 기능
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				int[] selectedRow = table.getSelectedRows();
				int[] selectedColumns = table.getSelectedColumns();

				for (int i = 0; i < selectedRow.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
					}
				}
				System.out.println("Selected: " + selectedData);
			}					
			
		});
		
		List<MypageDTO> list = mypageDAO.allopen();
		
		for (int a = 0; a < list.size(); a++) {
			MypageDTO mypageDTO = list.get(a);
			tableModel.addRow(new String[] { String.valueOf(a + 1), mypageDTO.getDaytime(), mypageDTO.getTitle(),
					mypageDTO.getPlace(), mypageDTO.getText() });
		}
		

	}

	public void init_panel2() {
		panel2.setLayout(null);
		
		buttonP1.setBounds(110,270, 120,38);
		buttonP1.setBorderPainted(false);
		buttonP1.setContentAreaFilled(false);
		buttonP1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonP1.addActionListener(this);

		buttonP2.setBounds(110,350,120,38);
		buttonP2.setBorderPainted(false);
		buttonP2.setContentAreaFilled(false);
		buttonP2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonP2.addActionListener(this);

		buttonP3.setBounds(110,420,120,38);
		buttonP3.setBorderPainted(false);
		buttonP3.setContentAreaFilled(false);
		buttonP3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonP3.addActionListener(this);

		buttonR1.setBounds(430,270,120,38);
		buttonR1.setBorderPainted(false);
		buttonR1.setContentAreaFilled(false);
		buttonR1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonR1.addActionListener(this);
		
		buttonR2.setBounds(430,350,120,38);
		buttonR2.setBorderPainted(false);
		buttonR2.setContentAreaFilled(false);
		buttonR2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonR2.addActionListener(this);

		buttonR3.setBounds(430,420,120,38);
		buttonR3.setBorderPainted(false);
		buttonR3.setContentAreaFilled(false);
		buttonR3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonR3.addActionListener(this);

		buttonH1.setBounds(750,270,150,38);
		buttonH1.setBorderPainted(false);
		buttonH1.setContentAreaFilled(false);
		buttonH1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonH1.addActionListener(this);
		
		buttonH2.setBounds(750,350,140,38);
		buttonH2.setBorderPainted(false);
		buttonH2.setContentAreaFilled(false);
		buttonH2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonH2.addActionListener(this);
		
		buttonH3.setBounds(750,420,140,38);
		buttonH3.setBorderPainted(false);
		buttonH3.setContentAreaFilled(false);
		buttonH3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonH3.addActionListener(this);
		
		panel2.add(buttonR1);
		panel2.add(buttonR2);
		panel2.add(buttonR3);
		panel2.add(buttonH1);
		panel2.add(buttonH2);
		panel2.add(buttonH3);
		panel2.add(buttonP1);
		panel2.add(buttonP2);
		panel2.add(buttonP3);
		
		
		panel2.add(lableNotice);
		lableNotice.setBounds(442,-24,800,200);
		notice = "공지사항을 알려드립니다";
		lableNotice.setFont(new Font("맑은 고딕",Font.BOLD,15));
		lableNotice.setForeground(Color.blue);
		
		
		(new Thread() {
			public void run() {
				List<DTONotice> list2 = new ArrayList<DTONotice>();
				DAONotice on= new DAONotice();
				list2=on.getNotice();
				DTONotice dtonotice = new DTONotice();
				String[] noticeF;
				while(true) {
					
				
				for(int a = 0 ; a<list2.size();a++) {
					noticeF = new String[list2.size()];
					dtonotice = list2.get(a);
					String time2 = dtonotice.getTime();
					String title2 = dtonotice.getTitle();
					String text2 = dtonotice.getText();
					noticeF[a] = time2 + "  [" + title2 + "] : " + text2;
					notice = noticeF[a];
					lableNotice.setText(notice);
					try {
						Thread.sleep(5000);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				}
			}
		}).start();

		
		
	}
	
	public void init_mypage() {
		
		// 패널3(마이페이지탭)구성
		panel3.setLayout(new BorderLayout());
		panel3.setBorder(new EmptyBorder(75, 65, 80, 60));
		// 상단
		panel3.add("North", panel_top);
		panel_top.setBorder(new EmptyBorder(10,0,20,0));
		panel_top.setLayout(new BorderLayout());
		panel_top.setBackground(new Color(255, 0, 0, 0));
		panel_top.add("West", label_my);
		panel_top.add("Center", p1);
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p1.setBackground(new Color(255, 0, 0, 0));
		// 센터-텍스트에리어영역
		   panel3.add("Center", panel_center);
		   panel_center.setLayout(new BorderLayout());
		   panel3.add("South", p1);
		   p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		   p1.setOpaque(false);
		   p1.setBorder(new EmptyBorder(10,0,0,5));
		   p1.add(button1);
//		   button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   button1.setPreferredSize(new Dimension(30, 30));
		   button1.setBorderPainted(false);
		   button1.setContentAreaFilled(false);
		   p1.add(button2);
		   button2.setPreferredSize(new Dimension(30, 30));
		   button2.setBorderPainted(false);
		   button2.setContentAreaFilled(false);
//		   button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   p1.add(button3);
		   button3.setPreferredSize(new Dimension(30, 30));
		   button3.setBorderPainted(false);
		   button3.setContentAreaFilled(false);
//		   button3.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	public void set_write() {

		write.setTitle("나의 여행 다이어리");
		write.setSize(520, 700);
		write.setLocation(300, 200);
		
		dcontainer.setLayout(new BorderLayout());
		
		//상단패널구성
		dcontainer.add("North", dpanel1);
		dpanel1.setLayout(new GridLayout(4, 1, 0, 5));
		dpanel1.setBorder(new EmptyBorder(15, 15, 15, 15));
		//상단1 :날짜, 항목
		dpanel1.add(dp1);
		dp1.setLayout(new BorderLayout());
		dp1.add("West", dp2);
		dp2.add(dlabel1);
		dp2.add(dtextField1);
		dtextField1.setForeground(Color.LIGHT_GRAY);
		dp1.add("East", dp3);
		dp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//상단2 : 날씨고르기
		dpanel1.add(dp4);
		dp4.setLayout(new BorderLayout());
		dp4.add("West", dlabel3);
		dp4.add("Center",dp5);
		dp5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dp5.add(dwhether1);
		dp5.add(dwhether2);
		dp5.add(dwhether3);
		dp5.add(dwhether4);
		dp5.add(dwhether5);
		dbuttonGroup1.add(dwhether1);
		dbuttonGroup1.add(dwhether2);
		dbuttonGroup1.add(dwhether3);
		dbuttonGroup1.add(dwhether4);
		dbuttonGroup1.add(dwhether5);
		//상단3 : 제목입력 텍스트 필드
		dpanel1.add(dtextField2);
		dtextField2.setForeground(Color.LIGHT_GRAY);
		dtextField2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		//상단4 : 장소입력 텍스트 필드
		dpanel1.add(dtextField3);
		dtextField3.setForeground(Color.LIGHT_GRAY);
		dtextField3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		//센터패널
		dcontainer.add("Center", dpanel2);
		dpanel2.setLayout(new BorderLayout());
		dpanel2.setBorder(new EmptyBorder(15, 15, 15, 15));
		//센터1 : 사진올리기
		dpanel2.add("North", dp6);
		dp6.setLayout(new BorderLayout());
		dp6.add("West", dlabel4);
		dp6.add(dp7);
		dp7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dp7.add(dbutton1);
		dbutton1.setEnabled(false);
		//센터2 : 텍스트에리어
		dpanel2.add("Center", dscrollPane);
		dtextArea.setForeground(Color.LIGHT_GRAY);
		dtextArea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		dtextArea.setLineWrap(true);
		
		//센터3 : 평가버튼
		dpanel2.add("South", dp8);
		dp8.setLayout(new BorderLayout());
		dp8.add("West", dlabel5);
		dp8.add("East", dp9);
		dp9.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dp9.add(dfeel1);
		dp9.add(dfeel2);
		dp9.add(dfeel3);
		dp9.add(dfeel4);
		dp9.add(dfeel5);
		dbuttonGroup2.add(dfeel1);
		dbuttonGroup2.add(dfeel2);
		dbuttonGroup2.add(dfeel3);
		dbuttonGroup2.add(dfeel4);
		dbuttonGroup2.add(dfeel5);
		
		//버튼패널
		dcontainer.add("South", dpanel3);
		dpanel3.setBorder(new EmptyBorder(20, 10, 12, 10));
		dpanel3.setLayout(new FlowLayout());
		dpanel3.add(dbutton2);
		dpanel3.add(dbutton3);
		
		//대화상자 편집
		dialog_finish.setSize(200, 100);
		dialog_finish.setLocation(600, 450);
		dialogContainer.setLayout(new BorderLayout());
		dialogContainer.add("Center", dialogLabel_finish);

	}

	public void start_mypage() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		button1.addActionListener(this);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);
		button3.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
	
		
	}

	public void event_newCreate() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) { // 1번 클릭
					table = (JTable) e.getComponent();
					tableModel = (DefaultTableModel) table.getModel();
					int row = table.getSelectedRow();

					String finder = (String) table.getValueAt(row, 4);
					MypageDTO mypageDTO = new MypageDTO();
					mypageDTO = mypageDAO.lookAtMyContent(finder);

					dtextArea.setText(mypageDTO.getText());
					dtextArea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					dtextArea.setForeground(Color.black);
					dtextArea.setEditable(false);
					
					dtextField1.setText(mypageDTO.getDaytime());
					dtextField1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					dtextField1.setForeground(Color.black);
					dtextField1.setEditable(false);
					
					
					dtextField2.setText(mypageDTO.getPlace());
					dtextField2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					dtextField2.setForeground(Color.black);
					dtextField2.setEditable(false);
					
					dtextField3.setText(mypageDTO.getTitle());
					dtextField3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
					dtextField3.setForeground(Color.black);
					dtextField3.setEditable(false);
					
					dbutton2.setEnabled(false);
					
					String whether = mypageDTO.getWhether();
					
					if (whether.equals("맑음")) {
						dwhether1.setSelected(true);
					} else if (whether.equals("비")) {
						dwhether2.setSelected(true);
					} else if (whether.equals("흐림")) {
						dwhether3.setSelected(true);
					} else if (whether.equals("눈")) {
						dwhether4.setSelected(true);
					} else if (whether.equals("바람")) {
						dwhether5.setSelected(true);
					}

					String feel = mypageDTO.getFeel();

					if (feel.equals("매우만족")) {
						dfeel1.setSelected(true);
					} else if (feel.equals("만족")) {
						dfeel2.setSelected(true);
					} else if (feel.equals("보통")) {
						dfeel3.setSelected(true);
					} else if (feel.equals("별로")) {
						dfeel4.setSelected(true);
					} else if (feel.equals("최악")) {
						dfeel5.setSelected(true);
					}

					
					write.setVisible(true);
				}

			}
		});
	}
	
	public void event_write() {

		write.dispose();

		// 마우스 클릭시 내용입력모드로
		dtextField1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				if (e.getSource() == dtextField1) {
					dtextField1.setText("");
					dtextField1.setForeground(Color.BLACK);
					super.mouseClicked(e);
				}
				}
			}
		});
		dtextField2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				if (e.getSource() == dtextField2) {
					dtextField2.setText("");
					dtextField2.setForeground(Color.BLACK);
					super.mouseClicked(e);
				}
				}
			}
		});
		dtextField3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				if (e.getSource() == dtextField3) {
					dtextField3.setText("");
					dtextField3.setForeground(Color.BLACK);
					super.mouseClicked(e);
				}
				}
			}
		});
		dtextArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				if (e.getSource() == dtextArea) {
					dtextArea.setText("");
					dtextArea.setForeground(Color.BLACK);
					super.mouseClicked(e);
				}
				}
			}
		});

		// 버튼 이벤트
		dbutton2.addActionListener(this);
		dbutton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dbutton3.addActionListener(this);
		dbutton3.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 대화상자 이벤트설정
		dialog_finish.setDefaultCloseOperation(HIDE_ON_CLOSE); // 닫기

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		
		// 메인홈 버튼 이벤트
		if (e.getSource() == button1) {
			dtextField1.setForeground(Color.LIGHT_GRAY);
			dtextField1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			dtextField1.setText(" 00-00-00 ");
			dtextField1.setEditable(true);
			
			dtextField2.setForeground(Color.LIGHT_GRAY);
			dtextField2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			dtextField2.setText(" 장소을 입력해주세요.");
			dtextField2.setEditable(true);
			
			dtextField3.setForeground(Color.LIGHT_GRAY);
			dtextField3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			dtextField3.setText(" 제목를 입력해주세요.");
			dtextField3.setEditable(true);
			
			dtextArea.setForeground(Color.LIGHT_GRAY);
			dtextArea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			dtextArea.setText(" 여행 다이어리 내용을 입력해주세요. ");
			dtextArea.setEditable(true);
			
			dwhether1.setSelected(false);
			dwhether2.setSelected(false);
			dwhether3.setSelected(false);
			dwhether4.setSelected(false);
			dwhether5.setSelected(false);
			
			dfeel1.setSelected(false);
			dfeel2.setSelected(false);
			dfeel3.setSelected(false);
			dfeel4.setSelected(false);
			dfeel5.setSelected(false);
			
			dbutton2.setEnabled(true);
			write.setVisible(true);
			

		} else if (e.getSource() == button2) {
			  int n = table.getSelectedRow();
		         tableModel = (DefaultTableModel)table.getModel();
		    
			// 삭제 기능
		    int r= 0; 
		    int k = 0;
		    r=JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?", "닫기", JOptionPane.YES_NO_OPTION);
			if(r==0) {
			     if(n>=0 && n<table.getRowCount()) {
			            tableModel.removeRow(n);
			         }
			k = mypageDAO.delete(selectedData);
			System.out.println("r? " + r + ", k?" + k);
			if(k>0) {
				String title = "데이터 삭제";
				String result = "선택하신 '" + selectedData + "' 가 삭제 되었습니다.";
				Dialog dialog = new Dialog(title, result);
			
			}else {
				String title = "데이터 삭제";
				String result = "오류발생, 잠시 후 다시 시도해주세요.";
				Dialog dialog = new Dialog(title, result);
				
			}
		}
			

		} else if (e.getSource() == button3) { // 전체 불러오기
			
			String title = "나의 리뷰";
			String result = "업데이트 되었습니다.";
			Dialog dialog = new Dialog(title, result);
			
			// 1.테이블 내용 초기화
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			// 2.데이터베이스 처리
			List<MypageDTO> list = mypageDAO.allopen();
			for (int a = 0; a < list.size(); a++) {
				MypageDTO mypageDTO = list.get(a);
				tableModel.addRow(new String[] { String.valueOf(a + 1), mypageDTO.getDaytime(), mypageDTO.getTitle(),
						mypageDTO.getPlace(), mypageDTO.getText() });

			}
		} else if(e.getSource()==buttonR1) {
			String title = " 춘심이네 본점";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\rest1.jpg";
			dialogPhoto = new DialogPhoto(title,result);
			
		}else if(e.getSource()==buttonR2) {
			String title = "쌍둥이 횟집";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\rest2.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonR3) {
			String title = "오는정김밥";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\rest3.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonH1) {
			String title = "켄싱턴제주호텔";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\hotel1.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonH2) {
			String title = "제주신라호텔";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\hotel2.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonH3) {
			String title = "한아름하우스";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\hotel3.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonP1) {
			String title = "성산일출봉";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\place1.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonP2) {
			String title = "한라산";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\place2.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}else if(e.getSource()==buttonP3) {
			String title = "섭지코지";
			String result= "C:\\Users\\Jeon Seonghwan\\Desktop\\for java work space\\ProjectK\\img\\place3.jpg";
			dialogPhoto = new DialogPhoto(title,result);
		}

		
		// 쓰기창 버튼 이벤트
		if (e.getSource() == dbutton2) { // 저장
			
			// (1)데이터 베이스에 저장하기
			// 1.텍스트필드 읽어오기
			String daytime = dtextField1.getText();
			String place = dtextField2.getText();
			String title = dtextField3.getText();
			String whether = "";
			String feel = "";
			// 2.체크버튼 내용 읽어오기
			if (dwhether1.isSelected()) {
				whether = "맑음";
			} else if (dwhether2.isSelected()) {
				whether = "비";
			} else if (dwhether3.isSelected()) {
				whether = "흐림";
			} else if (dwhether4.isSelected()) {
				whether = "눈";
			} else if (dwhether5.isSelected()) {
				whether = "바람";
			}
			;
			// 3.라디오버튼 내용 읽어오기
			if (dfeel1.isSelected()) {
				feel = "매우만족";
			} else if (dfeel2.isSelected()) {
				feel = "만족";
			} else if (dfeel3.isSelected()) {
				feel = "보통";
			} else if (dfeel4.isSelected()) {
				feel = "별로";
			} else if (dfeel5.isSelected()) {
				feel = "최악";
			}
			;
			// 4.텍스트에리어 내용 읽어오기
			String text = dtextArea.getText();
			// 5.입력검사

			// 6.데이터베이스에 읽어온 내용 처리
			MypageDTO mypageDTO = new MypageDTO(daytime, whether, place, title, text, feel);
			int su = mypageDAO.insert(mypageDTO);
			// 7.저장완료 창 띄우기
			dialog_finish.setVisible(true);

			tableModel.addRow(new String[] { " ", mypageDTO.getDaytime(), mypageDTO.getTitle(), mypageDTO.getPlace(),
					mypageDTO.getText() });

		} else if (e.getSource() == dbutton3) {
			int k = 0;
			k = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "닫기", JOptionPane.YES_NO_OPTION);
			System.out.println(k);
			if (k == -1) {
				return;
			} else if (k == 0) {
				write.setVisible(false);
			} else {
				
			}

		}

	}

	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
