package tojeju;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Dialog extends JFrame {
	
	Container container = getContentPane();
	
	JButton button = new JButton("확인");
	JLabel label;
	String title = "";
	String result = "";
	JPanel panel = new JPanel();
	
	public Dialog(String title,String result) {
		setTitle(title);
		setSize(300,150);
		setLocation(400,400);
		label = new JLabel(result, JLabel.CENTER);
		
		label.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		container.setLayout(new BorderLayout());
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