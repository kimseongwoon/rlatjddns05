package sec01.exam02;

// 내부적으로는 java.lang.Object 클래스를 자동 상속이 됨
public class Member extends Object { 
    // 필드
	public String id;
	
	// 생성자
	public Member(String id) {
		// super();	// 생략되어 있음(Object의 기본생성자)
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { // ClassCastException 방지
			Member member = (Member)obj; // 강제형변환(casting)
	
			if (id.equals(member.id))
				return true;
		}
		
		return false;
	}

}