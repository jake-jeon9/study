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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


class Event2 extends JFrame implements ActionListener {

	Container container = getContentPane();
	
	ImageIcon index2 = new ImageIcon("img/index2.png");
	ImageIcon watermark = new ImageIcon("img/watermark.png");

	ImageIcon img1 = new ImageIcon("img/1.png");
	ImageIcon img2 = new ImageIcon("img/2.png");
	ImageIcon img3 = new ImageIcon("img/3.png");
	ImageIcon img4 = new ImageIcon("img/4.png");
	ImageIcon img5 = new ImageIcon("img/5.png");
	ImageIcon img6 = new ImageIcon("img/6.png");
	
	ImageIcon icon3 = new ImageIcon("img/icon3.png");

	JLabel label1 = new JLabel(watermark);
	JLabel label2 = new JLabel(index2, JLabel.LEFT);

	JPanel panelN = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelS = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelSP = new JPanel();
	JPanel panelR = new JPanel();
	JPanel panelR2 = new JPanel();

	JButton buttonR = new JButton(icon3);
	JButton button1 = new JButton("닫기");
	JButton button2 = new JButton("리뷰 등록하러 가기");

	JButton buttonSP1 = new JButton(img1);
	JButton buttonSP2 = new JButton(img2);
	JButton buttonSP3 = new JButton(img3);
	JButton buttonSP4 = new JButton(img4);
	JButton buttonSP5 = new JButton(img5);
	JButton buttonSP6 = new JButton(img6);

	List<JPanel> listPH = new ArrayList<JPanel>();
	List<JButton> listBH = new ArrayList<JButton>();
	List<JLabel> listLH = new ArrayList<JLabel>();

	JScrollPane scrollPaneC = new JScrollPane(panelSP);
	JScrollBar bar = new JScrollBar();

	DAOInsertToServer dAOInsertToServer = new DAOInsertToServer();

	public Event2() {
		setTitle("리뷰 보기 (맛집)");
		setBounds(300, 300, 700, 550);
		init();
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		
		container.setLayout(new BorderLayout());
		container.add("North",panelN);
		container.add("Center",panelC);
		container.add("South",panelS);
		container.add("West",panelW);
		container.add("East",panelE);
		
		panelN.setLayout(new BorderLayout());
		panelN.setBorder(new EmptyBorder(15,22,5,15));
		panelN.add("Center", label1);
		panelN.add("South", label2);
		
		panelS.setLayout(new GridLayout(1,2));
		panelS.setBorder(new EmptyBorder(10,15,12,15));
		panelS.add(panelR);
		panelS.add(panelR2);
		
		panelR.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelR.add(buttonR);
		buttonR.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonR.setPreferredSize(new Dimension(30, 30));
		buttonR.setBorderPainted(false);
		buttonR.setContentAreaFilled(false);
		
		panelR2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelR2.add(button1);
		panelR2.add(button2);
		
		panelC.setLayout(new GridLayout(1,1));
		panelC.setBorder(new EmptyBorder(5,15,0,15));
		panelSP.setBackground(Color.WHITE);
		panelC.add(scrollPaneC);

		panelSP.setLayout(new FlowLayout(FlowLayout.LEFT,40,40));
		panelSP.setPreferredSize(new Dimension(500,500));

	}

	private void start() {
		button1.addActionListener(this);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);
		buttonR.addActionListener(this);
		buttonR.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonR) {
			String title = "맛집";
			
			String result = "업데이트 되었습니다.";
			Dialog dialog = new Dialog(title, result);
			
			
			
			List<DTOInsertToServer> list = dAOInsertToServer.takerootAll(title);

			for (int i = 0; i < list.size(); i++) {
				DTOInsertToServer dTOInsertToServer = list.get(i);

				JPanel[] panelReview = new JPanel[list.size()];
				JButton[] buttonReview = new JButton[list.size()];
				JLabel[] labelReview = new JLabel[list.size()];
				String getPhotoroot = dTOInsertToServer.getRootPhoto();
				String subject = dTOInsertToServer.getSubject();
				int k = subject.length();
				String sub_cut;
				if(k>8) {
					sub_cut = subject.substring(0,8)+"..";
				}
				else {
					sub_cut=dTOInsertToServer.getSubject();
				}
				
				panelReview[i] = new JPanel();
				ImageIcon img = new ImageIcon(getPhotoroot);
				buttonReview[i] = new JButton(img);
				labelReview[i] = new JLabel(sub_cut, JLabel.CENTER);
				labelReview[i].setFont(new Font("맑은 고딕",Font.BOLD,15));
				buttonReview[i].setBackground(Color.WHITE);
				buttonReview[i].setBorder(new MatteBorder(0, 0, 0, 0, Color.WHITE));

				listPH.add(panelReview[i]);// 그냥패널
				listBH.add(buttonReview[i]);// 사진
				listLH.add(labelReview[i]);// 제목

				JPanel temp = listPH.get(i);
				panelSP.add(temp);
				temp.setLayout(new BorderLayout());
				temp.add("Center", listBH.get(i));
				temp.add("South", listLH.get(i));
				buttonReview[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
				buttonReview[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent k) {
					
					EnrollReview on = new EnrollReview();
					on.setData(subject,title);
					on.EnrollReview();
					
					
					
				}
				});
				
			}
			validate();
			paint(this.getGraphics());
			
			String getDeleteData = new DeleteDeduplication().DeleteDeduplicationCall();
			System.out.println(getDeleteData);
		}

		if (e.getSource() == button1) {
			this.dispose(); // 내가 연창 하나 닫기
		} else if (e.getSource() == button2) {
			new Review2();
		}

	}
}

public class CallListOfRestaurants {

}
