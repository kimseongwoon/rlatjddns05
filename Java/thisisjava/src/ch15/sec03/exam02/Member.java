package ch15.sec03.exam02;

import java.util.Objects;

public class Member extends Object {
	public String name;
	public int age;
	
	// 생성자
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// hashCode 재정의 함수
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	// equals 재정의 함수
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member target) {
			return target.name.equals(name) // 이름과 나이가 같으면 true
					&& target.age == age;
		} else {							// 다르면 false
			return false;
		}
	}	
}
