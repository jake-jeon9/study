package tojeju;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class DialogPhoto extends JFrame {
	
	Container container = getContentPane();
	
	JButton button = new JButton("확인");
	JLabel label;
	ImageIcon img1;
	String title = "";
	
	
	BufferedImage img= null;
	JPanel panel = new JPanel();
	
	
	
	
	public DialogPhoto(String title,String result) {
		
		String k = result.substring(result.lastIndexOf("img"));
		ImageIcon icon = new ImageIcon(k);
		
		setTitle(title);
		setSize(icon.getIconWidth()+15,icon.getIconHeight()+67);
		setLocation(400,400);
		
//		try {
//			img1=new ImageIcon(result);
//			img = ImageIO.read(new File(result));
//			img = ImageIO.read(this.getClass().getResource(result));
//			img = ImageIO.read(new File(this.getClass().getResource(result)));
//		}catch(Exception e) {
//		}catch(IOException e) {
//			  e.printStackTrace();	
//		}
		
		container.setLayout(new BorderLayout());
//		img1 = new ImageIcon(result);
//		label = new JLabel(new ImageIcon(img));
//		ImageIcon icon = new ImageIcon(result);
		
		//ImageIcon icon = new ImageIcon("D:\android\java\workspace\new project\img\MainB.png");
//		ImageIcon icon = new ImageIcon("img/MainB.png");
		label = new JLabel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};

		label.setFont(new Font("맑은 고딕",Font.BOLD,15));
		container.add("Center",label);
		container.add("South",panel);
		panel.setLayout(new FlowLayout());
		panel.add(button);
		panel.setBorder(new EmptyBorder(0,0,10,0));
		button.setBackground(new Color(0xE1E1E1));
		
		start();

		setVisible(true);
	}

	private void start() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
}