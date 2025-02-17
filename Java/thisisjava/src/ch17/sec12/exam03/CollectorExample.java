package ch17.sec12.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ch17.sec12.exam01.Student;

public class CollectorExample {
	
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		// 남자, 여자 각각 평균값을 Map으로 저장하기(Key는 성별, Value는 성별에 따른 평균값)
		Map<String, Double> map = totalList.stream()
				.collect(Collectors.groupingBy(
						s -> s.getSex(),
						Collectors.averagingDouble(s -> s.getScore())
					));
		System.out.println(map);
	}
}
