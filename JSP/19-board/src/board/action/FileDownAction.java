package board.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1. 데이터처리
		String fileName = request.getParameter("downFile");
		//실제 폴더 위치 구하기
		String realPath = request.getServletContext().getRealPath("/boardUpload");
		//다운받고자 하는 파일 이름을 관리하는 FIle 객체생성
		File file = new File(realPath,fileName);
		
		if(!file.getParentFile().exists()) {
	         file.getParentFile().mkdirs();
	       }
	       if(!file.exists())  file.createNewFile();
	    //System.out.println("realPath : "+ realPath);
	    //System.out.println("fileName : "+ fileName);

		//html 문서가 파일 "파일 다운로드"형태로 전송
		//response 헤드 작성
		
		response.setHeader("Content-Disposition", "attachment; fileName="
		+ new String(URLEncoder.encode(fileName,"UTF-8")).replaceAll("\\+", " "));
		
		response.setHeader("Content-Length",String.valueOf(file.length()));
		
		//HDD에 저장된 파일을 RAM으로 읽어옴
		
		FileInputStream fis= null;
		
		fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] b = new byte[(int)file.length()];
		bis.read(b,0,b.length); //배열 b에 저장
		
		bis.close();
		fis.close();
		//클라이언트로 전송
			
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		bos.write(b);
		sos.close();
		
		return null;
	}

}
