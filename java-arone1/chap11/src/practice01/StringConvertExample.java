package practice01;

public class StringConvertExample {
	public static void main(String[] args) {
		String strData1 = "200";
		int intData1 = Integer.parseInt(strData1); // 문자열 200을 숫자 200으로 변경
				
		int intData2 = 150;
		String strData2 = String.valueOf(intData2); // 숫자 150을 문자열 150으로 변경
	}
}
