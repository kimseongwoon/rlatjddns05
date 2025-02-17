package ch17.sec04.exam02;

import java.util.*;
import java.util.stream.*;

public class StreamExample {
	
	public static void main(String[] args) {
		// 배열로부터 스트림 객체 얻기(String)
		String[] strArray = { "홍길동", "신용권", "김미나" };
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(item -> System.out.print(item + ",")); // 홍길동, 신용권, 김미나,
		System.out.println();
		
		// 배열로부터 스트림 객체 얻기(int)
		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.print(item + ",")); // 1, 2, 3, 4, 5,
		System.out.println();
	}
}
