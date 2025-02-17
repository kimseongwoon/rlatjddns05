package sec01.exam07;

import java.io.*;

public class WriterExample2 {
	public static void main(String[] args) throws Exception {
		// 문자기반의 출력 스트림 예제
		Writer writer = new FileWriter("./bin/sec01/test1.txt");
		//Writer writer = new FileWriter("./bin/sec01/test2.txt");
//		Writer writer = new FileWriter("./bin/sec01/test4.txt");
		
//		char a = 'A';
//		char b = 'B';
//		char c = 'C';
		writer.write('A');
//		writer.write(' ');
		writer.write('B');
//		writer.write(' ');
		writer.write('C');
		
//		char[] array = { 'A', 'B', 'C' };
//		writer.write(array);
		
//		writer.write("ABC");
		
		writer.flush();
		writer.close();
		
		System.out.println("프로그램 종료");
	}
}
