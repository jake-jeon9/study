package sample6;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Outputter {
	private String filePath;
	
	


	public String getFilePath() {
		return filePath;
	}




	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	@Override
	public void output(String message) throws IOException {
	//파일 출력
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}

}
