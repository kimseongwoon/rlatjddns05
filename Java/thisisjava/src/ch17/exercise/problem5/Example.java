package ch17.exercise.problem5;

import java.util.*;

public class Example {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"This is a java book",
				"Lambda Expressions",
				"Java8 supports lambda expressions"
		);
		// 대소문자 상관없이 'java'가 나오는 것을 출력
		list.stream()
			.filter(str -> str.toLowerCase().contains("java"))
			.forEach(str -> System.out.println(str));
	}
}
