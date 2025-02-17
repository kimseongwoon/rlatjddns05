package sec01.exam02;

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		String data1 = args[0];	// 프로그램 실행시에 매개변수를 받지 않으면 오류를 발생
		String data2 = args[1];
		
		System.out.println("args[0]; " + data1);
		System.out.println("args[1]; " + data2);
	}
}
