package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
	public static void main(String[] args) {
		//문장 스트림을 단어 스트림으로 변환
		List<String> list1 = new ArrayList<>();
		list1.add("this is java");
		list1.add("i am a best developer");
		
		// stream의 flatMap으로 복수 개의 요소로 변환
		/**
		 * 실행결과
		 *   this
		 *   is
		 *   java
		 *   i
		 *   am
		 *   a
		 *   ....
		 */
		list1.stream().flatMap(data -> Arrays.stream(data.split(" ")))
			.forEach(word -> System.out.println(word));
		
		System.out.println();
		//문자열 숫자 목록 스트림을 int숫자 스트림으로 변환
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream().flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			
			for(int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());  // trim은 공백 제거를 위해 삽입
			}
			
			return Arrays.stream(intArr);
		}).forEach(num -> System.out.println(num));
		
		System.out.println();
		//문자열 숫자 목록 스트림을 double숫자 스트림으로 변환
		List<String> list3 = Arrays.asList("10.0, 20.1, 30.5", "40.6, 50.78");
		list3.stream().flatMapToDouble(data -> {
			String[] strArr = data.split(",");
			double[] doubleArr = new double[strArr.length];
			
			for(int i = 0; i < strArr.length; i++) {
				doubleArr[i] = Double.parseDouble(strArr[i].trim());  // trim은 공백 제거를 위해 삽입
			}
			
			return Arrays.stream(doubleArr);
		}).forEach(num -> System.out.println(num));
	}
}
