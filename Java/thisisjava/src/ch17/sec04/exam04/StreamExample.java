package ch17.sec04.exam04;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.stream.*;

public class StreamExample {
	public static void main(String[] args) throws Exception {
		// 파일 읽기
		Path path 
			= Paths.get(StreamExample.class.getResource("data.txt").toURI());
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(line -> {
			line += " - 잘 나오나?";
			
			System.out.println(line);
		});
		stream.close();
	}
}
