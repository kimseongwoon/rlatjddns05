package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String args[]) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));
		
		// 1. 남학생만 묶기 
		// 2. 남학생만 묶은 List생성
		List<Student> maleList = totalList.stream()
			.filter(s -> s.getSex().equals("남"))
			.collect(Collectors.toList());
			//.toList(); // 더 간단하게 List로 받기
		
		// 실제 남학생만 출력이 되는지 확인
		maleList.stream()
			.forEach(s -> System.out.println(s.getName()));
		System.out.println();
		
		// 학생 이름을 키와 학생의 점수를 값으로 갖는 Map생성(List -> Map변경)
		Map<String, Integer> map = totalList.stream().collect(
			Collectors.toMap(s -> s.getName(), s -> s.getScore())
		);
		System.out.println(map);
	}
}
