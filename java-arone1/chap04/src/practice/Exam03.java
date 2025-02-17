package practice;

public class Exam03 {
	public static void main(String[] args) {
		while(true) {
			int num1 = (int)(Math.random() * 6) + 1; // 1 ~ 6
			int num2 = (int)(Math.random() * 6) + 1; // 1 ~ 6
			
			System.out.println("(" + num1 + ", " + num2 + ")");	// (눈1, 눈2)
			if (num1 + num2 == 5) {
				break;
			}
		}
	}

}
