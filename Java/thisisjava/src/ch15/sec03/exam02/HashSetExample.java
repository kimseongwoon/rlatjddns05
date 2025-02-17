package ch15.sec03.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();

		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30)); // 실행은 되지만 중복객체이기 때문에 저장은 되지 않음.
		
		//저장된 객체 수 출력
		int size = set.size();
		System.out.println("총 객체 수: " + size);
	}
}
