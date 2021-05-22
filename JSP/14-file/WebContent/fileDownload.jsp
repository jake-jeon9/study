<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String fileName=request.getParameter("fileName");
    //System.out.println("fileName 은? "+fileName);
    
    //파일이 저장된 실제 폴더 위치 구하기 
    String realPath = request.getServletContext().getRealPath("/storage");
    //file 객체에 다운받을 파일의 절대경로
	 File file = new File(realPath,fileName);
    //file : :D:\android_seonghwan\jsp\workspace\.metadata\.plugins\
    //org.eclipse.wst.server.core\tmp0\wtpwebapps\14-file\storage\아이유.png

    //System.out.println("file : :" + file);
    
    /* html 문서 형식이 아닌, "파일 다운로드" 형태로 전송 */
    //response 객체를 통해 setHeade설정 : 파일의 정보만 전송
    //1. 파일이름, 2.파일의 크기
    //response.setHeader("이름","데이터");
    
    //1.파일이름
    String set_fileName = new String(URLEncoder.encode(fileName,"utf-8")).replace("\\+"," ");
    //String(filename).replace(\\+,"") -> filename이 한글이면 엔코딩을 해줘야함,, 리플레이스에서 + 스는 없을때 다음 문자로 대체요청 
    response.setHeader("Content-Disposition","attachment; fileName="+set_fileName);
    
    //2.파일의 크기설정
    response.setHeader("Content-Lengh",String.valueOf(file.length()));
    
    
    //파일 출력
    //기존 jsp의 내장객체 outdml buffer를 비우고, 출력해야, 예외 발생이 안생김.
    //만약 클리어하지 않으면 outputsteam에서 이미 호출되었다고 충돌을 일으킴
    //에러 이유는 jsp를 servlet으로 변하는 과정에 생기는 outputStream 때문. jsp에서 java로 변환된거 보면 out.println이 사용됨.
    out.clear();
    out = pageContext.pushBody();
    
    //HDD에 저장된 파일을 RAM으로 읽어옴
    FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);
    
    byte[] b= new byte[(int)file.length()];
    bis.read(b,0,b.length);// b를 0부터 b크기까지 읽어오기 이에따라
    bis.close();
    fis.close();
    
    //클라이언트로 전송
    ServletOutputStream sos = response.getOutputStream();
    //servlet이 출력하니까 servlet에 response를 통해 데이터를 출력준비 
    BufferedOutputStream bos = new BufferedOutputStream(sos);
    bos.write(b);//실제로 이걸로 파일을 클라이언트에 전송함.
    bos.close();
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=fileName %>
</body>
</html>