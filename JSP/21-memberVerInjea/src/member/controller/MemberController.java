package member.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;

// WebServlet 에 들어있는 모양으로 요청이 들어오면 이 서블릿이 동작한다는 의미입니다. 차근차근 하나씩 따져보세요.
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 명령어와 명령어 처리 클래스를 쌍으로 저장할 MAP 클래스
	// 우리는 지금부터 String을 Key값(이름)으로하고 Object(객체)를 value값으로 map에 저장할겁니다.
	// key값을 통해 value를 불러오는거죠 쉽게 설명해서 (변수명 = 변수값) 이 (key = value)입니다. 똑같아요.
	private Map<String, Object> commandMap = new HashMap<String, Object>();
       
    public MemberController() {
        super();
    }
    // 명령어와 명령어 처리 클래스가 매핑되어있는 properties 파일을 읽어서 Map 클래스에 저장
    @Override
    public void init(ServletConfig config) throws ServletException {
    	//property파일이 담긴 폴더의 경로를 realFolder에 저장하고 실제로 우리가 요청정보=클래스 내용을 담고있는 command.property 파일명을 붙여
    	//실제 우리가 불러올 파일의 경로를 풀로 가져옵니다.
    	System.out.println("서블릿 init함수 호출");
    	String realFolder = config.getServletContext().getRealPath("/property");
    	String realPath = realFolder + "/command.properties";
    	
    	// 보조 인풋 스트림을 통해 이제 저 파일 안에 있는 내용들을 불러올겁니다. 그 key값을 받아올 수 있게 properties를 활용합니다.
    	FileInputStream fis = null;
    	Properties properties = new Properties();
    	try {
    		// 우리가 아까 만들어놓은 풀 경로로 해당 property 파일을 읽어옵니다.
			fis = new FileInputStream(realPath);
			// 그 뒤 properties 객체에 불러온 내용들을 저장합니다.
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	// iterator 객체 얻기
    	// iterator에는 아까 properties 객체에 저장된 키값을 전부 불러옵니다.
    	Iterator<?> iterator = properties.keySet().iterator();
    	while(iterator.hasNext()) {
    		// 만약 한개라면 이 while문은 한번만 동작할거에요. 근데 지금은 11개였나? 무튼 저희가 입력한 줄 수만큼 불러와서
    		// = 왼쪽값을 command로 불러옵니다.
    		String command = (String) iterator.next();
    		// 그리고 = 오른쪽값인 value를 className에 저장하게됩니다.
    		// 꼭 기억하세요. key값 = property값 으로 command.properties에 저장된겁니다.
    		String className = properties.getProperty(command);
    		
    		try {
    			// 객체 생성
    			// Class.forname을 통해 제가 properties에서 불러온 객체명이 실제로 존재하는 클래스인지 검사합니다.
				Class<?> commandClass = Class.forName(className);
				// 존재하게된다면 이제 commandClass에는 객체의 이름이 담겨있고, 그 이름으로 new해서 객체를 생성해줍니다. 아래 코드 확인
				Object commandInstance = commandClass.newInstance();
				// 맵 클래스에 저장
				// 이제 요청값과 클래스가 Map에 저장됩니다. 이 동작은 properties파일에 있는 줄 수만큼 계속 반복됩니다.(while)
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    // 1. 웹 브라우저 요청받기
    // 우리가 get방식으로 보내든 post방식으로보내든 어차피 doRequest가 동작하도록 설정했어요. 그냥 doRequest만 확인하시면 됩니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리 : 우리가 request로 받는데 한글로 받아서 깨질경우를 대비해 utf-8로 엔코딩 시켜줍니다.
		request.setCharacterEncoding("utf-8");
		// 2. 요청 정보 확인
		// forward는 우리가 이동할 경로를, action은 다양한 자식클래스를 부모클래스로 제어하는 다형성 방식을 이용하기위해 각각 선언해줬습니다.
		String forward = null;
		Action action = null;
		
		
		// 이제 우리는 요청정보를 풀로 가져오게됩니다.아래의 코드가 헷갈리시면 18-mvc에 예제 4번을 참조해주세요. 복붙입니다 ^^7
		String command = request.getRequestURI();
		String contextPath = request.getContextPath();
		int contextPathLength = request.getContextPath().length();
		
		if(command.indexOf(contextPath) == 0) {
			command = command.substring(contextPathLength);
			
			// model
			// 이제 map에 저장된 내용들을 우리가 받아온 요청정보로 불러들입니다.
			// index에서 설명드린 것 처럼 boardWriteForm.do라면
			// command = /boardWriteForm.do 가 되겠죠? 그걸로 boardWriteFormAction.java가 동작될겁니다.
			action = (Action) commandMap.get(command);
			// model 실행
			try {
				// 이제 위에 action에 담긴 클래스가 실행되고 우리가 갈 주소 foward를 반환할겁니다.
				forward = action.execute(request, response);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// view 처리 - forward 이동
			// 134번째 줄에서 얻은 forward로 공유된 변수들과 함께 이동하게됩니다.
			// Servlet의 큰 흐름은 이거와 같습니다.
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}
}
