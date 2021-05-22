package tojeju;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MakePlan extends JFrame {
//여행 경비 플래너

	Container container = getContentPane();

	JPanel panelR = new JPanel();
	JPanel panelL = new JPanel();

	JButton button = new JButton();

	JLabel label = new JLabel();

	JTextField textField = new JTextField();

	String[] columnName = { "날짜", "분류", "장소", "내용", "비용" };
	DefaultTableModel tableModel=new DefaultTableModel(columnName,0){public boolean isCellEditable(int row,int column){return false;}};
	JTable table = new JTable(tableModel);
	JScrollPane scrollPane = new JScrollPane(table);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void Calculator() {
	
TextField textField = new TextField("0");
Panel panelNum = new Panel();
Button[] buttonsNum = new Button[16];	//	객체 배열
Button buttonResult = new Button("=");
// 버튼 16개에 설정할 문자들
String[]  strs_num = {"7","8","9","/",
					   "4","5","6","*",
					   "1","2","3","-",
					   "0","+/-",".","+"};
String input ="";	// 입력값저장 변수
boolean positive = true;	// 음수 양수 판단용, true = 양수
double num1, num2, result;	// 입력 숫자와 계산 결과 저장
String op; 					// 연산자 저장(+, -, *, /)
int dot_cnt =0;				// 소수점 개수 카운트 용
}
//public CalculatorForm() {
//	// Frame 설정
//	setTitle("계산기");
//	setSize(250, 200);
//	setLocation(300, 300);
//	
//	init();
//	start();
//	
//	setResizable(false); 	//화면 크기 고정
//	setVisible(true);
//}
//
//	private void init() {
//		// Frame 구성
//		setLayout(new BorderLayout());
//		add("North", textField);
//		add("Center", panelNum);
//		add("South", buttonResult);
//		/** panel 구성 **/
//		// panelNum 설정
//		panelNum.setLayout(new GridLayout(4, 4, 4, 4));
//		panelNum.setBackground(Color.LIGHT_GRAY);
//		// panelNum 버튼 추가하기
//		for (int i = 0; i < buttonsNum.length; i++) {
//			buttonsNum[i] = new Button(strs_num[i]);
//			buttonsNum[i].setForeground(Color.BLUE); // 글자색
//			panelNum.add(buttonsNum[i]);
//		}
//		// 기타 설정
//		textField.setEditable(false); // 키보드 입력 금지
//		buttonResult.setForeground(Color.BLUE);
//	}
//
//	private void start() {
//		// 버튼 이벤트 설정
//		for (int i = 0; i < buttonsNum.length; i++) {
//			buttonsNum[i].addActionListener(this);
//		}
//		buttonResult.addActionListener(this);
//		// x버튼 이벤트 처리
//		super.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//				System.exit(0);
//			}
//		});
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == buttonsNum[0]) { // 7
//			input += "7";
//		} else if (e.getSource() == buttonsNum[1]) { // 8
//			input += "8";
//		} else if (e.getSource() == buttonsNum[2]) { // 9
//			input += "9";
//		} else if (e.getSource() == buttonsNum[3]) { // /
//			num1 = Double.parseDouble(input);
//			op = "/";
//			// 입력값 초기화
//			input = ""; // 입력값 저장변수 초기화
//			positive = true;// 양수 입력으로
//			dot_cnt = 0; // 소수점 개수 초기화
//		} else if (e.getSource() == buttonsNum[4]) { // 4
//			input += "4";
//		} else if (e.getSource() == buttonsNum[5]) { // 5
//			input += "5";
//		} else if (e.getSource() == buttonsNum[6]) { // 6
//			input += "6";
//		} else if (e.getSource() == buttonsNum[7]) { // *
//			num1 = Double.parseDouble(input);
//			op = "*";
//			// 입력값 초기화
//			input = ""; // 입력값 저장변수 초기화
//			positive = true;// 양수 입력으로
//			dot_cnt = 0; // 소수점 개수 초기화
//		} else if (e.getSource() == buttonsNum[8]) { // 1
//			input += "1";
//		} else if (e.getSource() == buttonsNum[9]) { // 2
//			input += "2";
//		} else if (e.getSource() == buttonsNum[10]) { // 3
//			input += "3";
//		} else if (e.getSource() == buttonsNum[11]) { // -
//			num1 = Double.parseDouble(input);
//			op = "-";
//			// 입력값 초기화
//			input = ""; // 입력값 저장변수 초기화
//			positive = true;// 양수 입력으로
//			dot_cnt = 0; // 소수점 개수 초기화
//		} else if (e.getSource() == buttonsNum[12]) { // 0
//			input += "0";
//		} else if (e.getSource() == buttonsNum[13]) { // +/- (양수/음수) 전환
//			if (positive) { // 양수이면
//				// 음수로 변환
//				input = '-' + input;
//				positive = false;
//				dot_cnt = 0; // 소수점 개수 초기화
//			} else { // 음수이면
//				// 양수로 변환
//				input = input.substring(1); // -문자뺴고 잘라오기
//				positive = true;
//			}
//		} else if (e.getSource() == buttonsNum[14]) { // . (소수점)
//			if (dot_cnt == 0) {
//				input += ".";
//				dot_cnt++;
//			}
//		} else if (e.getSource() == buttonsNum[15]) { // +
//			num1 = Double.parseDouble(input);
//			op = "+";
//			// 입력값 초기화
//			input = ""; // 입력값 저장변수 초기화
//			positive = true;// 양수 입력으로
//			dot_cnt = 0; // 소수점 개수 초기화
//		} else if (e.getSource() == buttonResult) { // =
//			num2 = Double.parseDouble(input);
//			switch (op) {
//			case "+":
//				result = num1 + num2;
//				break;
//			case "-":
//				result = num1 - num2;
//				break;
//			case "*":
//				result = num1 * num2;
//				break;
//			case "/":
//				result = num1 / num2;
//				break;
//			}
//			textField.setText(String.valueOf(result));
//			// 입력값 초기화
//			input = "";
//			num1 = num2 = 0;
//			positive = true;
//			dot_cnt = 0;
//			return; // 함수 종료
//		}
//		// 입력값 출력
//		textField.setText(input);
//	}
}