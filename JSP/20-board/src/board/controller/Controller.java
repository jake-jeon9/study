package board.controller;

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

import board.action.Action;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();
   
	public Controller() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		//"property" 폴더의 절대 경로를 구함
    	String realfolder = config.getServletContext().getRealPath("/property");
    	//절대 경로로 파일이름을 작성
    	String realPath = realfolder + "/command.properties";
    	//System.out.println("realPath : "+ realPath);
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
    	//properties파일의 command값이 저장되어 있음
    	Iterator<?> iterator = properties.keySet().iterator();
    	//iterator 객체에 저장된 명령어와 멸령어 처리 클래스를 Map 객체에 저장
    	while(iterator.hasNext()) {
    		String command = (String)iterator.next();	//properties 파일의 command값
    		String className = properties.getProperty(command);//properties파일의 command 값에 해당하는 클래스 이름
    		//System.out.println("className : " + className); ->className : exam3.mvc.MessageAction
    		//System.out.println("command : " + command); ->commend : message
    	
    		//객체생성
    		try {
        		// 클래스가 있는지 확인하고, 없으면 예외를 발생시키고, 있으면 class객체
				Class<?> commandClass = Class.forName(className);
	    		//객체 생성
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
	
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//웹브라우저의 요청을 분석하고, 해당 요청의 처리를 수행할 model 실행

		//2.요청정보 확인
		String command = request.getRequestURI();
		String contextPath = request.getContextPath();
		int contextPathLength = request.getContextPath().length();
		
		//String command2 = request.getServletPath();
		//System.out.println("request.getServletPath()" + command2);
		//System.out.println(" request.getRequestURI()" + command);
		
		if(command.indexOf(contextPath) == 0) {
			command = command.substring(contextPathLength);
		}
	
		//model 얻기
		action = (Action)commandMap.get(command);
		//action=(Action)commandMap.get(command2);
		
		//model 실행
		try {
			view = action.excute(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		//view 처리 - forward 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
