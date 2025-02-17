package ch17.sec07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("홍길동", 30));
		studentList.add(new Student("신용권", 10));
		studentList.add(new Student("유미선", 20));

		// 점수를 기준으로 오름차순(1, 2, ...)으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted()
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		
		System.out.println();
		
		// score기준으로 오름차순
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		
		// 점수를 기준으로 내림차순(10, 9, ...)으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		
		// score기준으로 내림차순
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		
	}
}
