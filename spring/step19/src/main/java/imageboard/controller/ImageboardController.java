package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;

@Controller
public class ImageboardController {
	@RequestMapping(value = "/imageboard/imageboardWriteForm")
	public String imageboardWriteForm() {
		return "imageboardWriteForm";
	}
	
	// MultipartFile img : 변수명 img는 <input type="file" name="img"> 태그의 name과 일치해야 한다.
	@RequestMapping(value = "/imageboard/imageboardWrite")
	public ModelAndView imageboardWrite(HttpServletRequest request, MultipartFile img) {		
		String filePath = 
			"D:\\android_ycs\\spring\\workspace\\step19\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		
		// 파일 복사
		// => getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageboardDTO dto = new ImageboardDTO();
		dto.setImageId(request.getParameter("imageId"));
		dto.setImageName(request.getParameter("imageName"));
		dto.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		dto.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		dto.setImageContent(request.getParameter("imageContent"));
		dto.setImage1(fileName);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("imageboardWrite");
		return modelAndView;
	}
}












