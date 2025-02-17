package ch15.exercise.problem9;

import java.util.*;
import java.util.Map.Entry;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		int avgScore = 0;
	
		// Map에 있는 모든 속성과 값들을 순회
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			//System.out.println(k + " : " + v);
			
			// 최고 점수 및 최고 점수를 받은 아이디 체크
			if(v > maxScore) {
				maxScore = v;
				name = k;
			}
			
			totalScore += v; // 총 합계 점수
		}
		avgScore = totalScore / map.size();		// 평균 점수
		
		System.out.println("평균 점수:" + avgScore);
		System.out.println("최고 점수:" + maxScore);
		System.out.println("최고 점수를 받은 아이디:" + name);
	}
}
