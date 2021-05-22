package exam3.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //명령어와 명령어 처리 클래스를 쌍으로 저장할 Map클래스
	
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
    public Controller() {
        super();
    }
    
    //톰캣서버가 서블릿을 처음 구동 시킬 때, 제일 먼저 호출되는 함수
    //--> 서블릿 초기화
    //명령어와 명령어 처리 클래스가 매핑되어 있는 properties 파일을 읽어올 Map 클래스에 저장
    
    @Override
	public void init(ServletConfig config) throws ServletException {
    	//"property" 폴더의 절대 경로를 구함
    	String realfolder = config.getServletContext().getRealPath("/property");
    	String realPath = realfolder + "/command.properties";
    	System.out.println("realPath : "+ realPath);
    	
    //properties 파일의 명령어와 처리 클래스의 매핑 정보를 저장할 properties 객체 생성
    	Properties properties = new Properties();
    	//파일을 읽어올 io 클래스
    	FileInputStream fis = null;
    	
    	try {
			fis= new FileInputStream(realPath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	//set 객체의 iterator() 메소드를 사용하여 Iterator 객체를 얻어냄
    	Iterator<?> iterator = properties.keySet().iterator();
    	//iterator 객체에 저장된 명령어와 멸령어 처리 클래스를 Map 객체에 저장
    	while(iterator.hasNext()) {
    		String command = (String)iterator.next();
    		String className = properties.getProperty(command);
    		//commend : message
    		//className : exam3.mvc.MessageAction
    		System.out.println("className : " + className);
    		System.out.println("command : " + command);
    	
    		try {
        		//exam3.mvc.MessageAction 클래스가 있는지 확인
				Class<?> commandClass = Class.forName(className);
	    		//exam3.mvc.MessageAction 객체 생성
				Object commandInstance = commandClass.newInstance();
				//Map 객체에 저장
				commandMap.put(command, commandInstance);
    		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String view = null;
	Action action = null;
	
	//웹브라우저의 요청을 분석하고, 해당 요청의 처리를 수행할 model 실행
	//2.요청정보 확인
	String command = request.getParameter("command");
	
	//3.작업 요청 처리(데이터 처리 클래스 선택)
	//4. 요청 처리 결과를 request 객체에 저장
	action = (Action)commandMap.get(command);
	try {
		view = action.process(request, response);
	} catch (Throwable e) {
		e.printStackTrace();
	}
	
	//처리된 결과를 view처리 파일로 이동해서 사용함
	RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	dispatcher.forward(request, response);
	
	}

	

}
