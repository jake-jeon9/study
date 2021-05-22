package tojeju;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class EnrollReview extends JFrame implements ActionListener{

	DTOTourismArea placeTourismArea = new DTOTourismArea();
	PTADAO ptadao;
	DTOInsertToServer dTOInsertToServer;
	Container container = getContentPane();
	DAOInsertToServer daoInsertToServer = new DAOInsertToServer();
	Login login;
	String getSubject;
	String getReview;
	String getComments;
	String subject1;
	String getName;
	String getRating;
	String getDate;
	
	
	JPanel MainTop = new JPanel();
	JPanel MainCenter = new JPanel();
	JPanel MainBotton = new JPanel();
	JPanel MainBotto = new JPanel();
	
	JPanel MainTopT = new JPanel();	//버튼
	JPanel MainTopC = new JPanel();	//제목
	JPanel MainTopB = new JPanel();	// 라벨
	
		
	JPanel MainCenterT = new JPanel();	//리뷰라인
	JPanel MainCenterTL = new JPanel();	//리뷰 라벨
	JPanel MainCenterTR = new JPanel();	//버튼
	
	JPanel MainCenterC = new JPanel();	//텍스트 박스
	
	JPanel MainCenterB = new JPanel();	//라벨 리뷰 등록시간 호출
	JPanel MainCenterBL = new JPanel();	//라벨 리뷰 등록시간 호출
	JPanel MainCenterBR = new JPanel();	//라벨 리뷰 등록시간 호출
	
	JPanel MainBottonT = new JPanel();	//라벨용
	JPanel MainBottonC = new JPanel();	//중앙
	JPanel MainBottonB = new JPanel();	//버튼용
	
	JPanel MainBottonCT = new JPanel();	//중앙 텍스트 박스
	
	JPanel MainBottonCC = new JPanel();	// 3개 
	JPanel MainBottonCCL = new JPanel();	// 닉네임박스 
	JPanel MainBottonCCC = new JPanel();	// 댓글남기기
	JPanel MainBottonCCR = new JPanel();	// 버튼

	JPanel panelMargin1 = new JPanel();	// 여백
	JPanel panelMargin2 = new JPanel();	// 여백
	JPanel panelMargin3 = new JPanel();	// 여백
	JPanel panelMargin4 = new JPanel();	// 여백
	JPanel panelMargin5 = new JPanel();	// 여백
	JPanel panelMargin6 = new JPanel();	// 여백
	JPanel panelMargin7 = new JPanel();	// 여백
	JPanel panelMargin8 = new JPanel();	// 여백
	
	JTextField textFieldSubject = new JTextField();
	JTextField textFieldNickName = new JTextField(10);
	JTextField textFieldComment = new JTextField(20);
	
	JTextArea textAreaReview = new JTextArea(10,10);
	JTextArea textAreaComments = new JTextArea(5,5);
	
	JScrollPane scrollReview = new JScrollPane(textAreaReview);
	JScrollPane scrollComments = new JScrollPane(textAreaComments);
	
	JButton button = new JButton("관광지");
	JButton button1 = new JButton("같이 등록된 사진보기");
	JButton button2 = new JButton("등록");
	JButton button3 = new JButton("닫기");
	
	JLabel labelWho = new JLabel(getName,JLabel.LEFT);
	JLabel labelEnroll = new JLabel("님이 등륵하신 리뷰입니다.",JLabel.LEFT);
	
	JLabel labelreview = new JLabel("글쓴이 REVIEW",JLabel.LEFT);

	JLabel labelRating = new JLabel("글쓴이 평점 : ",JLabel.LEFT);
	JLabel labelRatingHow =new JLabel(getRating);
	JLabel labelDate = new JLabel(getDate+"에 등록 됨",JLabel.RIGHT);
	
	JTextField contain = new JTextField(subject1);
	
	JLabel labelComment = new JLabel("COMMENTS",JLabel.LEFT);
	
	String data;
	String title;

	public void setData(String data,String title) {
		this.data = data;
		this.title = title;
	}
	
	public void EnrollReview() {
		
		setSize(520,700);
		setTitle("등록된 리뷰");
		setLocation(400,100);
		
		init();
		start();
		
		setVisible(true);
		
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",MainTop);
		container.add("Center",MainCenter);
		container.add("South",MainBotto);
		container.add("East",panelMargin1);
		container.add("West",panelMargin2);
		
		MainTop.setLayout(new BorderLayout());
		MainTop.add("East",panelMargin3);
		MainTop.add("West",panelMargin4);
//		MainTop.setBorder(new EmptyBorder(15,15,15,15));
		
			MainTop.add("North",MainTopT);
				MainTopT.setLayout(new FlowLayout(FlowLayout.RIGHT));
				MainTopT.add(button);
				button.setText(title);
		
			
			MainTop.add("Center",MainTopC);
				MainTopC.setLayout(new BorderLayout());
				MainTopC.add("Center",textFieldSubject);
				
		
			MainTop.add("South",MainTopB);
				MainTopB.setLayout(new FlowLayout(FlowLayout.LEFT));
				MainTopB.add(labelWho);
				MainTopB.add(labelEnroll);
				
		
		MainCenter.setLayout(new BorderLayout());
		MainCenter.add("North",MainCenterT);
			MainCenterT.setLayout(new GridLayout(1,2));
			MainCenterT.add(MainCenterTL);
			MainCenterT.add(MainCenterTR);
			
			MainCenterTL.setLayout(new FlowLayout(FlowLayout.LEFT));
			MainCenterTL.add("West",labelreview);
			
			MainCenterTR.setLayout(new FlowLayout(FlowLayout.RIGHT));
			MainCenterTR.add("East",button1);
			
		MainCenter.add("Center",MainCenterC);
			MainCenterC.setLayout(new BorderLayout());
			MainCenterC.add(scrollReview);
		
		MainCenter.add("South",MainCenterB);
		
			MainCenterB.setLayout(new BorderLayout());
			MainCenterB.add("West",MainCenterBL);
			MainCenterB.add("East",MainCenterBR);
			
				MainCenterBL.setLayout(new FlowLayout(FlowLayout.LEFT));
				MainCenterBL.add(labelRating);
				MainCenterBL.add(labelRatingHow);
			
			
				MainCenterBR.setLayout(new FlowLayout(FlowLayout.RIGHT));
				MainCenterBR.add(labelDate);
		
	MainBotto.setLayout(new BorderLayout());
	MainBotto.add("Center",MainBotton);
	MainBotto.add("East",panelMargin5);
	MainBotto.add("West",panelMargin6);
		
//		MainBotton.setLayout(new GridLayout(3,1,3,3));
		MainBotton.setLayout(new BorderLayout());
		MainBotton.add("North",MainBottonT);
		MainBotton.add("Center",MainBottonC);
		MainBotton.add("South",MainBottonB);
		
			MainBottonT.setLayout(new FlowLayout(FlowLayout.LEFT));
			MainBottonT.add(labelComment);
			labelComment.setPreferredSize(new Dimension(80,40));
			MainBottonC.setLayout(new BorderLayout());
			MainBottonC.add("Center",scrollComments);
			scrollComments.setMaximumSize(new Dimension(520, 50));
			MainBottonC.add("South",MainBottonCC);
			
			
				MainBottonCC.setLayout(new BorderLayout());
				MainBottonCC.add("West",textFieldNickName);
				MainBottonCC.add("Center",textFieldComment);
				MainBottonCC.add("East",button2);
		
			MainBottonB.setLayout(new FlowLayout());
			MainBottonB.add(button3);
		
		//스크롤 기능
		textAreaComments.setDragEnabled(true);
		textAreaComments.setSelectionColor(Color.blue);;
		textAreaComments.setSelectedTextColor(Color.WHITE);
		textAreaReview.setDragEnabled(true);
		textAreaReview.setSelectionColor(Color.BLUE);;
		textAreaComments.setSelectedTextColor(Color.WHITE);
		
		scrollComments.setWheelScrollingEnabled(true);
		scrollReview.setWheelScrollingEnabled(true);
		
		
		//글꼴색상
		labelEnroll.setForeground(Color.LIGHT_GRAY);
		labelWho.setForeground(Color.LIGHT_GRAY);
		
		textFieldComment.setText("댓글남기기");
		textFieldComment.setForeground(Color.lightGray);
		textAreaComments.setEditable(false);
		textAreaReview.setEditable(false);
		textFieldNickName.setEditable(false);
		textFieldSubject.setEditable(false);

		//텍스트 area 셋팅
	
		PTADAO pTADAO = new PTADAO();
		
		
//		System.out.println(contain.getText());
		
		
		List<DTOTourismArea> list = pTADAO.getReviewList(data);
		for(int i=0; i<list.size(); i++) {
			DTOTourismArea dto = list.get(i);
//			insertMyReview(dto);
			textAreaReview.setText(dto.getReview());
			textFieldSubject.setText(dto.getSubject());
			labelDate.setText(dto.getTime());
			labelWho.setText(dto.getId());
			textFieldNickName.setText(login.getMyId());
			labelRatingHow.setText(dto.getRating());
		}
	
		List<DTOCategoryComments> getcomments = pTADAO.getCommentsList(textFieldSubject.getText());
		for(int i=0; i<getcomments.size(); i++) {
	
			DTOCategoryComments dto = getcomments.get(i);
			insertMyReview(dto);
			String getDeleteData = new DeleteDeduplication().DeleteDeduplicationCall();
			System.out.println(getDeleteData);
			
		}
		textAreaComments.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textAreaReview.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textFieldSubject.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textFieldNickName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		labelreview.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
	}

	private void start() {
	
		button1.addActionListener(this);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);
		button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		textFieldComment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent k) {
				if (k.getClickCount() == 2) {
				textFieldComment.setText("");
				textFieldComment.setForeground(Color.black);
			}
			}	});
		
//		textFieldNickName.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent k) {
//				textFieldNickName.setText("");
//				textFieldNickName.setForeground(Color.black);
//			}	});
//		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean clickCount = true;
		if(e.getSource()==button1) {
			
			if(clickCount) {
			
			String getsubject = textFieldSubject.getText();
			String title = button.getText(); //관광지,호텔,맛집 중 가져와야함.
			DTOInsertToServer dtoinsertoserver = new DTOInsertToServer();
//			System.out.println("getsubject : "+ getsubject +"/ , title : " + title);
			
			dtoinsertoserver = daoInsertToServer.takeroot(getsubject, title);
//			String haveroot = daoInsertToServer.takerootonly(getsubject, title);
			String getPhotoroot = dtoinsertoserver.getRootPhoto();
			String subject = dtoinsertoserver.getSubject();
			
			if(dtoinsertoserver!=null) {
				
				new DialogPhoto(subject,getPhotoroot);
				
//				new DialogPhoto(getsubject,haveroot);
			
				
			}else {
				String title3 = "설정 오류";
				String result = "찾으시는 사진이 없습니다.";
				Dialog dialog = new Dialog(title3, result);
			}
			clickCount=false;
			}
			
			
			
		}else if(e.getSource()==button2) {
			
			PTADAO inMyReview = new PTADAO();
			String getmyname = login.getMyId();
			String mycomment = textFieldComment.getText();
			String getsubject = textFieldSubject.getText();
			
			int newreview = inMyReview.addComment(getsubject,getmyname,mycomment);
			if(newreview>0) {
				String title = "댓글 작성";
				String result = "댓글이 정상적으로 입력되었습니다.";
				Dialog dialog = new Dialog(title, result);
				
			}else {
				String title = "댓글 작성";
				String result = "댓글작성 실패하였습니다.";
				Dialog dialog = new Dialog(title, result);
				
			}
			
			MainBottonC.remove(scrollComments);
			MainBottonC.invalidate();
			MainBottonC.add("Center",scrollComments);
			MainBottonC.revalidate();
			MainBottonC.repaint();
			

			
		
			

			
			
		}else if(e.getSource()==button3) {
			super.dispose();
		}
		
		
	}
	public void insertMyReview(DTOCategoryComments dTOCategoryComments) {
		String getcomments = dTOCategoryComments.getComments();
		String getId = dTOCategoryComments.getId();
		
		String str = ""; 
		str = str+getId+" : "+getcomments+"\n";
		
		textAreaComments.append(str);	// 문자열 1줄 추가
	}
	
	public void getAlldata(DTOInsertToServer dTOInsertToServer) {
		DTOInsertToServer newData = dTOInsertToServer;
		
		String subject2 = newData.getSubject();
		contain.setText(subject2);
//		System.out.println(subject2);
		
	}
	

	
			
}

