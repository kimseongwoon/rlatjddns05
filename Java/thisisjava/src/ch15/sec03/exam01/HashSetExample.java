package ch15.sec03.exam01;

import java.util.*;

public class HashSetExample {
	
	public static void main(String[] args) {
		// Set의 동등 값의 의미는 hashCode값이 같으며 equals의 리턴값이 true인 경우임
		// HashSet 컬렉션 객체 생성
		Set<String> set = new HashSet<>();
		
		// 객체 저장
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");    // 실행은 되지만 중복객체이기 때문에 저장은 되지 않음.
		set.add("iBatis");
		
		//저장된 객체 수 출력
		int size = set.size();
		System.out.println("총 객체 수: " + size);
	}
}
