package ch17.sec05;

import java.util.*;

public class FilteringExample {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("신용권");
		list.add("박병렬");
		
		// 중복 요소 제거(2개의 '신용권'이 1개의 '신용권'으로 필터링 됨)
		list.stream().distinct().forEach(a -> System.out.println(a));
		
		// '신'으로 시작하는 요소만 필터링
		list.stream().filter(a -> a.startsWith("신")).forEach(a -> System.out.println(a));
		
		// 중복 요소를 먼저 제거하고, '신'으로 시작하는 요소만 필터링
		list.stream().distinct().filter(a -> a.startsWith("신")).forEach(a -> System.out.println(a));
	}
}
