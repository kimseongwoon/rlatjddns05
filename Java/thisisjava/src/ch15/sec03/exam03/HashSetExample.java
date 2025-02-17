package ch15.sec03.exam03;

import java.util.*;

public class HashSetExample {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		// 객체 저장
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");		
		set.add("iBatis");

		// 객체를 하나씩 가져와서 처리하기
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			// 객체를 하나씩 가져오기
			String element = iterator.next();
			System.out.println(element);
			// element의 값이 JSP일 때 컬렉션에서 제거
			if(element.equals("JSP")) {
				iterator.remove(); // 가져온 객체를 컬렉션에서 제거
			}
		}
		System.out.println();
		
		set.remove("JDBC");  // 값이 JDBC인 객체를 삭제
		set.remove("aaaaaaaaa");  // 없는 값은 실행은 되지만 무시
		
		for(String element : set) { // while(iterator.hasNext())와 동일한 기능
			System.out.println(element);  // Java  Spring
		}	
	}
}
