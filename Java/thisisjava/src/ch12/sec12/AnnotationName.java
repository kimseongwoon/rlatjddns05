package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target은 클래스, 인터페이스, 열거타입, 필드(멤버 필드), 메소드, 패키지만 적용하겠다는 뜻
 * @Retention은 어노테이션 작동 유지 정책으로 RUNTIME은 실행할 때 적용
 */
@Target({ ElementType.TYPE, 
			ElementType.PACKAGE,
			//ElementType.CONSTRUCTOR,
			ElementType.FIELD, 
			ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
	String value();		// Annotation사용시 기본 속성으로 세팅되는 이름
	String prop1();
	int prop2() default 1;
}