package ch17.sec12.exam02;

import java.util.*;
import java.util.stream.Collectors;

import ch17.sec12.exam01.Student;

public class CollectorExample {
	
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		// 성별을 Key로 하고 성별에 따른 학생 리스트를 값으로 하는 List가져오기
		// ex) "남", List로 남학생
		//     "여", List로 여학생
		Map<String, List<Student>> map = totalList.stream()
				.collect(Collectors.groupingBy(s -> s.getSex()));
		
		// 남자, 여자 각각 List로 출력
		List<Student> maleList = map.get("남");
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();
		List<Student> femaleList = map.get("여");
		femaleList.stream().forEach(s -> System.out.println(s.getName()));
		
		// 옛날 방식
		List<Student> maleList2 = new ArrayList<>();
		List<Student> femaleList2 = new ArrayList<>();
		for(Student stu : totalList) {
			if (stu.getSex().equals("남")) {
				maleList2.add(stu);
			} else {
				femaleList2.add(stu);
			}
		}
	}
}
