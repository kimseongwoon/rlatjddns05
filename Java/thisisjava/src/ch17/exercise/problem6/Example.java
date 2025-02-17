package ch17.exercise.problem6;

import java.util.*;

public class Example {
	
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", 30),
				new Member("신용권", 40),
				new Member("감자바", 26)
		);
		
		double avg = list.stream()
						//.mapToInt(Member::getAge)
						.mapToInt(member -> member.getAge())
						.average()
						.getAsDouble();
		System.out.println("평균 나이:" + avg);

	}
}
