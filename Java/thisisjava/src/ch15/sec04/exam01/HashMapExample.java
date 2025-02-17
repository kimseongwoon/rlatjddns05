package ch15.sec04.exam01;

import java.util.*;
import java.util.Map.*;

public class HashMapExample {
	public static void main(String[] args) {
		// Map 컬렉션 생성
		Map<String, Integer> map = new HashMap<>();
		
		// Map객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // 기존에 있던 홍길동의 90은 지워지고 95로 덮어씌워짐. Set과 반대
		
		System.out.println("총 Entry 수: " + map.size()); // 3
		System.out.println();
		// 홍길동을 key인 값 얻기
		int value = map.get("홍길동");
		System.out.println("홍길동: " + value);
		System.out.println();
		
		// 키로 순회하기. 키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			String k = keyIterator.next();
			Integer v = map.get(k);
			System.out.println(k + " : " + v);
		}
		System.out.println();
		
		// 키로 엔트리 삭제하기
		map.remove("홍길동");
		
		// 엔트리로 순회하기
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k + " : " + v);
		}
		System.out.println();
	}
}
