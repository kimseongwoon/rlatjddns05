package sec02;

import java.util.Scanner;

public class Exam11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디:");
		String name = scanner.nextLine();
		
		System.out.print("패스워드:");
		String strPassword = scanner.nextLine();
		
		int password = Integer.parseInt(strPassword);
		if (name.equals("java")) {   // name == "java" (X) 나중에 배울 hashCode, equals함수가 같을 때 '=='이 성립됨
			if (password == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
		
		// x > 7  -> true    y <= 5      true   ->  true && true -> true
		// x % 3 == 2 -> false    y % 2 != 1 false   ->  false || fasle -> false
		
		// int score = 85;
		// (!(score > 90)) ? "가" : "나";		// (!false) -> true
	}
}
