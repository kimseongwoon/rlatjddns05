package ch17.exercise.problem8;

import java.util.*;
import java.util.stream.Collectors;

public class Example {
	
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", "개발자"),
				new Member("김나리", "디자이너"),
				new Member("신용권", "개발자")
		);
		
		Map<String, List<Member>> groupingMap = list.stream()
				.collect(Collectors.groupingBy(Member::getJob));
		
		System.out.println("[개발자]");
		List<Member> devList = groupingMap.get("개발자");
		devList.stream().forEach(s -> System.out.println(s));
		
		System.out.println("[디자이너]");
		List<Member> designerList = groupingMap.get("디자이너");
		designerList.stream().forEach(s -> System.out.println(s));
	}
}
