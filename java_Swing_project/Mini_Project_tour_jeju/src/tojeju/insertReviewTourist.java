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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

class Review extends JFrame implements ActionListener, MouseListener {
	
	ImageIcon review1 = new ImageIcon("img/review1.png");
	
	EnrollReview enrollReview;
	
	Container container = getContentPane();

	JPanel panelNorth = new JPanel();
	JPanel panelNorthC = new JPanel();

	JPanel panelCenter = new JPanel();

	JPanel panelCenterC = new JPanel();
	JTextArea textReview = new JTextArea(" 리뷰 내용을 입력하세요.");
	JScrollPane scrollPane = new JScrollPane(textReview);
	JTextPane pane = new JTextPane();

	JPanel panelCenterS = new JPanel();
	JLabel reviewCS = new JLabel("이 곳의 평점을 매겨주세요", JLabel.LEFT);
	JPanel panelRadio = new JPanel();
	JRadioButton radioButton1 = new JRadioButton("매우만족");
	JRadioButton radioButton2 = new JRadioButton("만족");
	JRadioButton radioButton3 = new JRadioButton("보통", true);
	JRadioButton radioButton4 = new JRadioButton("별로");
	JRadioButton radioButton5 = new JRadioButton("최악");
	ButtonGroup buttonGroup = new ButtonGroup();

	JPanel panelCenterN = new JPanel();
	JLabel reviewPCNW = new JLabel("REVIEW", JLabel.LEFT);
	JButton buttonSajin = new JButton("사진 업로드");

	JButton buttonSave = new JButton("업 로 드");
	JButton buttonCancel = new JButton("취    소");

	JPanel panelSouth = new JPanel();

	JLabel buttonRT = new JLabel(review1);
	// JLabel labelW = new JLabel(name);

	JDialog dialog1 = new JDialog();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel("업로드 하시겠습니까?");

	JPanel panel11 = new JPanel();
	JButton button1 = new JButton("예(Y)");
	JButton button11 = new JButton("아니오(N)");

	JDialog dialog2 = new JDialog();
	JPanel panel2 = new JPanel();
	JLabel label2 = new JLabel("취소 하시겠습니까?");

	JPanel panel22 = new JPanel();
	JButton button2 = new JButton("예(Y)");
	JButton button22 = new JButton("돌아가기");

	String up = "제목을 입력하세요.";
	JTextField textFieldUP = new JTextField(" 제목을 입력하세요.");

	String rating = "";

	String subject, review = "";

	DAOInsertToServer dao = new DAOInsertToServer();
	
	//파일추저
	JFileChooser fileChooser = new JFileChooser("D:\\android\\java\\workspace\\new project\\img\\");
	String getPhotoroot;
	int k =0;

	public void setRating(String rating) {
		this.rating = rating;

	}

	public String getRating() {
		return rating;
	}

	public Review() {
		setTitle("리뷰 등록");
		setSize(600, 550);
		setLocation(100, 100);

		init();
		start();

		setVisible(true);
		setResizable(false);
	}

	private void init() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				super.windowClosing(e);
			}
		});
		container.setLayout(new BorderLayout());
		container.add("North", panelNorth);
		container.add("Center", panelCenter);
		container.add("South", panelSouth);

		panelNorth.setLayout(new GridLayout(2, 1));
		panelNorth.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelNorth.add(panelNorthC);
		panelNorth.add(textFieldUP);
		textFieldUP.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textFieldUP.setForeground(Color.GRAY);

		panelNorthC.setLayout(new BorderLayout());
		panelNorthC.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelNorthC.add("East", buttonRT);

		panelCenter.setLayout(new BorderLayout());
		panelCenter.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelCenter.add("North", panelCenterN);
		panelCenter.add("Center", panelCenterC);
		panelCenter.add("South", panelCenterS);

		panelCenterN.setLayout(new BorderLayout());
		panelCenterN.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelCenterN.add("West", reviewPCNW);
		panelCenterN.add("East", buttonSajin);
		buttonSajin.setBackground(new Color(0xe1e1e1));

		panelCenterC.setLayout(new BorderLayout());
		panelCenterC.add("Center", scrollPane);
		textReview.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textReview.setForeground(Color.GRAY);
		textReview.setLineWrap(true);

		panelCenterS.setLayout(new BorderLayout());
		panelCenterS.add("West", reviewCS);
		panelCenterS.add("East", panelRadio);
		panelRadio.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelRadio.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelRadio.add(radioButton1);
		panelRadio.add(radioButton2);
		panelRadio.add(radioButton3);
		panelRadio.add(radioButton4);
		panelRadio.add(radioButton5);

		panelSouth.setLayout(new FlowLayout());
		panelSouth.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelSouth.add(buttonSave);
		buttonSave.setBackground(new Color(0xe1e1e1));
		panelSouth.add(buttonCancel);
		buttonCancel.setBackground(new Color(0xe1e1e1));

		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		buttonGroup.add(radioButton4);
		buttonGroup.add(radioButton5);

	}

	private void start() {
		textFieldUP.addMouseListener(this);
		textReview.addMouseListener(this);
		buttonSave.addActionListener(this);
		buttonSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonCancel.addActionListener(this);
		buttonCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button1.addActionListener(this);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button11.addActionListener(this);
		button11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button22.addActionListener(this);
		button22.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonSajin.addActionListener(this);
		buttonSajin.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonSave) {
			choose1();
		} else if (e.getSource() == buttonCancel) {
			choose2();
		} else if(e.getSource()==buttonSajin) {
			if(k==0) {
				getPhotoroot=FileColorChooser();
			k=1;				
			}else {
				String subject = "선택한 파일명 : "+getPhotoroot.substring(getPhotoroot.lastIndexOf("img")+4,getPhotoroot.indexOf("."));
				System.out.println(subject);
				new DialogPhoto(subject,getPhotoroot);
			
				buttonSajin.setText("업로드된 파일 보기");
				buttonSajin.repaint();
			}
			
		}
		if (radioButton1.isSelected()) {
			rating = "매우만족";

		} else if (radioButton2.isSelected()) {
			rating = "만족";

		} else if (radioButton3.isSelected()) {
			rating = "보통";

		} else if (radioButton4.isSelected()) {
			rating = "별로";

		} else if (radioButton5.isSelected()) {
			rating = "최악";

		}
		boolean clickCount = true;
		if (e.getSource() == button1) {
			if(clickCount) {
				subject = textFieldUP.getText();
				review = textReview.getText();
				DTOInsertToServer reviewDTO3 = new DTOInsertToServer(subject, review, rating);
				dao.insertArticle(reviewDTO3);
				dialog1.dispose();

				
				String rootPhoto =getPhotoroot; 
				String title1 = "관광지";
				int checkresult;
				checkresult=dao.insertroot(subject, rootPhoto,title1);
//				System.out.println("checkresult 값은? " +checkresult);
//				System.out.println("rootPhoto 값은? " +rootPhoto);
				if(checkresult>0) {
					String title = "파일 업로드 ";
					String result ="서버에 파일이 성공적으로 업로드 되었습니다.";
					Dialog dialog = new Dialog(title, result);
				}else {
					String title = "파일 업로드 ";
					String result = "사진을 등록해주세요.";
					Dialog dialog = new Dialog(title, result);
				}
				
				

				super.dispose();
				clickCount=false;
				String getDeleteData = new DeleteDeduplication().DeleteDeduplicationCall();
				System.out.println(getDeleteData);
			}
			

		
		} else if (e.getSource() == button11) {
			dialog1.dispose();
		} else if (e.getSource() == button2) {
			dialog2.dispose();
			// 리뷰등록창 없애기
			super.dispose();
		} else if (e.getSource() == button22) {
			dialog2.dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent k) {
		if (k.getClickCount() == 2) {
		if (k.getSource() == textFieldUP) {
			textFieldUP.setText("");
			textFieldUP.setForeground(Color.BLACK);
		} else if (k.getSource() == textReview) {
			textReview.setText("");
			textReview.setForeground(Color.BLACK);
		}
		}
	}

	@Override
	public void mouseEntered(MouseEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent k) {
		// TODO Auto-generated method stub

	}

	private int choose1() {

		dialog1.setTitle("리뷰 등록하기");
		dialog1.setLayout(new BorderLayout());
		dialog1.add("Center", panel1);
		dialog1.add("South", panel11);
		dialog1.setLocation(250, 300);
		panel1.add(label1);
		panel11.add(button1);
		panel11.add(button11);
		dialog1.pack();

		dialog1.setVisible(true);

		int i = 1;

		return i;

	}

	private void choose2() {
		dialog2.setTitle("취소");
		dialog2.setLayout(new BorderLayout());
		dialog2.add("Center", panel2);
		dialog2.add("South", panel22);
		dialog2.setLocation(250, 300);
		panel2.add(label2);
		panel22.add(button2);
		panel22.add(button22);
		dialog2.pack();

		dialog2.setVisible(true);
	}
	public String FileColorChooser() {
		fileChooser.setDialogTitle("불러오기");
		fileChooser.setMultiSelectionEnabled(true); // 다중 선택 가능
		fileChooser.showDialog(this, "열기");
		File[] files = fileChooser.getSelectedFiles();
		getPhotoroot="";
		for (int i = 0; i < files.length; i++) {
			System.out.println("파일명 = " + files[i]);
			getPhotoroot += files[i];
		}
		return getPhotoroot;
	}
}

public class insertReviewTourist {
	
}
