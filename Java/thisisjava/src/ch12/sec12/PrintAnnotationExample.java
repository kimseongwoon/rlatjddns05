package ch12.sec12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class PrintAnnotationExample {
	
	public static void main(String[] args) 
			throws Exception {
		// Service클래스의 있는 모든 메소드를 조회
		Method[] declaredMethods 
			= Service.class.getDeclaredMethods();
		for(Method method : declaredMethods) {
			System.out.println("method 이름: " + method.getName());
			
			Annotation[] annos = method.getAnnotations();
			for(Annotation anno : annos) {
				System.out.println("annotation 이름: " + anno);
			}
			
			// PrintAnnotation 객체변수 얻기
			PrintAnnotation printAnnotation
			= method.getAnnotation(PrintAnnotation.class);
			
			//설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
			
			// Service의 메소드들 실행
			method.invoke(new Service());
			
//			int number = printAnnotation.number();  // 각 메소드의 선언된 number속성 값을 가져오기
//			String value = printAnnotation.value(); // 각 메소드의 선언된 value속성 값을 가져오기
//					
//			System.out.println("number값: " + number);
//			System.out.println("value값: " + value);
			
			//설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
		}
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if(printAnnotation != null) {
			//number 속성값 얻기
			int number = printAnnotation.number();
			for(int i=0; i<number; i++) {
				//value 속성값 얻기
					String value = printAnnotation.value();
					System.out.print(value);
			}
			System.out.println();
		}
	}
}
