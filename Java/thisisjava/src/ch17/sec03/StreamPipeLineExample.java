package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);
		
		
		Stream<Student> studentStream = list.stream();
		// 학생 객체의 점수만 가져오는 stream만들기(중간처리)
		IntStream scoreStream 
			= studentStream.mapToInt(student -> student.getScore());
		// 평균 점수 가져오기(최종처리)
		double avg = scoreStream.average().getAsDouble();
		System.out.println("평균점수: " + avg);
		
		// 좀 더 간단하게 처리(한 줄로 처리) -> 메소드 체이닝(method chainning)
		System.out.println("평균점수: " + list.stream().mapToInt(student -> student.getScore()).average().getAsDouble());
	}
}
