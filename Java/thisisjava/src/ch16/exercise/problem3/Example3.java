package ch16.exercise.problem3;

import ch16.sec01.Calculable;

public class Example3 {
	public static void main(String args[]) {
		// 람다식으로 변경 실행
		action1(a -> a+3);
		action2((a,b) -> a*b);
	}
	
	public static Integer action1(TestInter testInter) {
		return 1;
	}
	public static Integer action2(TestInter2 testInter2) {
		return 1;
	}
}
