package sec02;

public class Exam05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1 / var2; 		// 5 / 2 -> 2  근데 double받으면 2.0
		int var4 = (int)(var3 * var2);	// 2.0 * 2 -> 4.0   근데 int캐스팅하면 4
		System.out.println(var4);
	}

}
