package practice;

import java.util.Scanner;

public class Exam02_06 {

	public static void main(String[] args) {
		boolean run = true;

		int studentNum = 0;		// 학생수
		int[] scores = null;	// 학생들의 점수 배열

		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}			
			} else if (selectNo == 4) {
				int 최고점수 = 0;
				double 평균점수 = 0.0;
				
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					if (최고점수 < scores[i]) {
						최고점수 = scores[i];
					}
//					최고점수 = 최고점수 < scores[i] ? scores[i] : 최고점수; 	// 삼항 연산자
					sum += scores[i];
				}
				평균점수 = sum / (double)studentNum;
				
				System.out.println("최고 점수: " + 최고점수);
				System.out.println("평균 점수: " + 평균점수);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}

