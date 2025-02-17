package sec05.exam02;

public class CarculatorExample {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Carculator.PI;
	    int result2 = Carculator.plus(10, 5);
	    int result3 = Carculator.minus(10, 5);
	    System.out.println("result1 : " + result1);
	    System.out.println("result2 : " + result2);
	    System.out.println("result3 : " + result3);
	
	
	    // static으로 된 멤버들은 객체에서 호출하는 것을 지양
	    Carculator cal1 = new Carculator();
	    double result12 = 10 * 10 * cal1.PI;
	    int result22 = cal1.plus(10, 5);
	    int result32 = cal1.minus(10, 5);
	    System.out.println("result12 : " + result12);
	    System.out.println("result22 : " + result22);
	    System.out.println("result32 : " + result32);
	}
}