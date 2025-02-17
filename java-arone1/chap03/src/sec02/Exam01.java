package sec02;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		int z = (++x) + (y--); // (1) x = x + 1 -> 11    (2) z = 11 + y(20) -> 31   (3) y = y(20) - 1 -> 19
		
		System.out.println(x);  // 11
		System.out.println(y);  // 19
		System.out.println(z);  // 31
	}

}
