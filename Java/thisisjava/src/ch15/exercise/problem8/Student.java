package ch15.exercise.problem8;

public class Student {
	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	}
	
	// 학번이 같으면 동일한 Student이도록 작성
	// 1. hashCode값이 같아야 함. 여기서는 학번이 hashCode값이어야 함
	@Override
	public int hashCode() {
		return this.studentNum;
	}
	
	// 2. equals의 리턴값이 true
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student stu = (Student) obj;
			if(this.studentNum == stu.studentNum)
				return true;
		}
		
		return false;
		/*
		if(!(obj instanceof Student))
			return false;		
		Student stu = (Student) obj;
		if(this.studentNum != stu.studentNum)
			return false;
		
		return true;
		*/
	}
}
