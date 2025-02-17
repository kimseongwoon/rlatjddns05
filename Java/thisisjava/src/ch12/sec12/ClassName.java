package ch12.sec12;

//속성값이 없으면 기본으로 value속성에 들어감
@AnnotationName(value = "bcd", prop1 = "a", prop2 = 2)  
public class ClassName {
	@AnnotationName(value = "a1", prop1 = "b")
	private String fieldName;
	
	// error: Target에 ElementType.CONSTRUCTOR가 없기 때문에
	//@AnnotationName(value = "a1", prop1 = "b") 
	public ClassName() {
		
	}
	
	@AnnotationName(value = "a1", prop1 = "b")
	public void methodName() {
		
	}
}
