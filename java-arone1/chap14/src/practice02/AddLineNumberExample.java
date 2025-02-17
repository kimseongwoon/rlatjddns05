package practice02;

import java.io.*;

public class AddLineNumberExample {
	public static void main(String[] args) throws Exception {
		String filePath = "src/practice02/AddLineNumberExample.java";
		
		Reader reader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(reader); // Reader 보조 스트림 사용
		
		int rowNumber = 1;
		while(true) {
			String dataLine = br.readLine();
			if(dataLine == null) break;	// 파일의 끝에 도달했을 경우 null임
			System.out.println((rowNumber++) + ": " + dataLine);
		}
		
		br.close();
	}
}
