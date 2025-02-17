package practice;

public class Exam02 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			// 3의 배수는 나머지가 3으로 나누었을 때 나머지가 0인 숫자
			if (i % 3 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("3의 배수의 합 -> " + sum);
	}
}
