

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class NewWindow2 extends JFrame {

	Container container = getContentPane();

	JPanel jPanelT = new JPanel();
	JPanel jPanelBR = new JPanel();
	JPanel jPanelBL = new JPanel();

	JLabel label1 = new JLabel("테스트1");
	JLabel label2 = new JLabel("테스트2");
	JLabel label3 = new JLabel("테스트3");

	JTextArea textArea1 = new JTextArea();
	JTextArea textArea2 = new JTextArea();
	JTextArea textArea3 = new JTextArea();

	public NewWindow2() {

		setTitle("관련 여행정보");
		setSize(400, 500);
		setLocation(400, 400);

		init();
		start();

		setVisible(true);

	}

	public void init() {

		container.setLayout(new GridLayout(3, 1));
		container.add(jPanelT);
		container.add(textArea1);
		container.add(label1);
		textArea1.setText("테스트");
		textArea2.setText("테스트");
		textArea3.setText("테스트");

		jPanelT.setLayout(new GridLayout(1, 4));
		jPanelT.add(textArea2);
		jPanelT.add(label2);
		jPanelT.add(label3);
		
		jPanelT.add(textArea3);

	}

	public void start() {

	}

}

public class startNewWindow {
	public static void main(String[] args) {
		new NewWindow2();
		
		
	}
	
}
